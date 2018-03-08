package br.com.dxc.core.connection.servidor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Value;

import br.com.dxc.dto.FaseExecucaoDTO;
import br.com.dxc.exception.ApplicationBusinessExceptionCode;
import br.com.dxc.exception.ApplicationValidatorException;

/**
 * Abstração responsável em enviar um arquivo via FTP através de um objeto
 * conexão
 * 
 * @author robson
 *
 */
public class ServidorFTP extends Servidor {

	private FTPClient ftpClient;

	private static final String FTP_FILE_SEPARATOR = "/";

	private static final String PARAMETRO_AGENDAMENTO_COMPLEMENTO_URI = "complementoUri";

	private static final String REGISTRO_TIPO_TRANSMISSAO_FTP = "1";

	private static final String REGISTRO_SITUACAO_STATUS_OPERACAO_EFETUADA_COM_SUCESSO = "00";

	private static final String REGISTRO_SITUACAO_STATUS_ENVIADO = "1";

	private static final String REGISTRO_SITUACAO_STATUS_RECEBIDO = "2";

	private static final String REGISTRO_SITUACAO_STATUS_ERRO = "5";

	private static final String PARAMETRO_AGENDAMENTO_PASTA_UPLOAD_ALTERNATIVO = "pastaUploadAlternativo";

	private static final String SYSTEM_FILE_SEPARATOR = "file.separator";

	private static final String PARAMETRO_FTP_DESTINO_ARQUIVO_NA_PORTAL = "diretorioDestino";

	private static final String TIPO_CAIXA_POSTAL_FORMA_ENVIAR = "enviar";

	@Value("${ftp.timeout}")
	private Integer FTP_TIMEOUT;

	@Value("${ftp.tentativas.conexao}")
	private Integer FTP_TENTATIVAS_CONEXAO;

	@Value("${pasta.arquivoUsuario}")
	private String PASTA_ARQUIVO_USUARIO;

	public ServidorFTP() {
		super();
	}

	public ServidorFTP(Conexao conn) {
		super(conn);
		log.info("Conexão tipo FTP Criada");
	}

	/**
	 * Conecta ao servidor de FTP
	 */
	@Override
	public Boolean conectar(Map parametros) throws Exception {
		if (!this.isConectado()) {
			String caminhoInicial = ServidorFTP.FTP_FILE_SEPARATOR;
			String complementoUri = (String) parametros.get(PARAMETRO_AGENDAMENTO_COMPLEMENTO_URI);
			if (complementoUri != null) {
				if (complementoUri.startsWith(caminhoInicial)) {
					caminhoInicial = complementoUri;
				} else {
					caminhoInicial = caminhoInicial + complementoUri;
				}
			}

			ftpClient = getFtpConnection(caminhoInicial);
		}

		return ftpClient.isConnected();
	}

	/**
	 * Faz a conexão com um servidor FTP (se usada diretamente, não utilizará a
	 * estrutura do servidor de aplicações).
	 * 
	 * @param caminhoInicial
	 * 
	 * @return uma conexão FTP
	 * @throws Exception 
	 */
	public FTPClient getFtpConnection(String caminhoInicial) throws Exception {
		FTPClient clientConnection = null;

		int porta = this.getConn().getPorta() != null ? new Integer(this.getConn().getPorta()) : 21;

		// tenta até o máximo de vezes configurado, conectar no FTP
		for (int i = 1; i <= FTP_TENTATIVAS_CONEXAO; i++) {

			try {
				clientConnection = new FTPClient();

				clientConnection.connect(this.getConn().getUri(), porta);
				clientConnection.login(this.getConn().getUsuario(), this.getConn().getSenha());

				int reply = clientConnection.getReplyCode();

				if (!FTPReply.isPositiveCompletion(reply)) {
					clientConnection.disconnect();
					throw new ApplicationValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_CONEXAO_FTP,
							this.getConn().getUri(), porta);
				}

				clientConnection.setDataTimeout(FTP_TIMEOUT);
				clientConnection.setControlKeepAliveReplyTimeout(FTP_TIMEOUT);
				clientConnection.setControlKeepAliveTimeout(FTP_TIMEOUT / 60000); // minutos

				if (!clientConnection.changeWorkingDirectory(caminhoInicial)) {
					String msg = ApplicationBusinessExceptionCode.CRESOL_LOG_FTP_CONNECTION.getDescricao() + caminhoInicial;
					log.error(msg);
					throw new Exception(msg);
				}

				log.info("conectado no FTP: " + this.getConn().getUri() + "; porta: " + porta);
				break;
			} catch (Exception e) {
				log.error(ApplicationBusinessExceptionCode.CRESOL_ERROR_MENSAGEM_DEFAULT.getDescricao(), e);
				log.error("Erro ao tentar conectar com endereco FTP: " + this.getConn().getUri() + "; porta: " + porta
						+ " - tentativa " + i + " de " + FTP_TENTATIVAS_CONEXAO);

				if (i == FTP_TENTATIVAS_CONEXAO) {
					throw e;
				} else {
					// sleep entre 2 e 4 segundos
					Long milli = (new Double(Math.random() * 2000 + 2000)).longValue();
					log.error("Thread vai aguardar antes de nova tentativa: " + milli + " millisegundos.");
					Thread.sleep(milli);
				}
			}
		}

		return clientConnection;
	}

	/**
	 * Envia os arquivos ao servidor
	 * 
	 * @throws IOException
	 */
	@Override
	public String enviar(Map parametros) throws Exception {
		String statusRetorno = null;
		String destino = null;
		try {
			for (Anexo anexo : this.getConn().getArquivos()) {
				log.info("Arquivo a enviar via FTP: " + anexo.getNome());
			}
			if (conectar(parametros)) {
				if (this.getConn().getArquivos() != null) {
					statusRetorno = REGISTRO_SITUACAO_STATUS_ENVIADO;
					destino = (String) parametros.get("destino");
					for (Anexo anx : this.getConn().getArquivos()) {
						InputStream objeto = null;
						try {
							objeto = new ByteArrayInputStream(anx.getArquivo());

							if (!StringUtils.isBlank(destino)) {
								ftpClient.storeFile(destino + ServidorFTP.FTP_FILE_SEPARATOR + anx.getNome(), objeto);
							} else {
								ftpClient.storeFile(anx.getNome(), objeto);
							}

							String retornoComando = this.processarResposta();

							if (REGISTRO_SITUACAO_STATUS_ERRO.equals(retornoComando)) {
								statusRetorno = retornoComando;
							}
						} catch (Exception e) {
							log.error("ERRO_COLMEIA_INESPERADO: ", e);
							throw e;
						} finally {
							if (objeto != null) {
								objeto.close();
							}
						}
					}

				} else {
					statusRetorno = REGISTRO_SITUACAO_STATUS_ERRO;
				}
			} else {
				statusRetorno = REGISTRO_SITUACAO_STATUS_ERRO;
			}
		} catch (Exception e) {
			log.error("ERRO_COLMEIA_INESPERADO: Erro no metodo ServidorFTP.enviar: ", e);
			Collection<Anexo> anexos = getConn().getArquivos();
			StringBuffer arquivos = new StringBuffer("");
			if (anexos != null) {
				for (Anexo anexo : anexos) {
					arquivos.append(anexo.toString() + "\n");
				}
			}
			log.error("Arquivos de envio: " + arquivos);
			throw e;
		} finally {
			desconectar();
		}
		return statusRetorno;
	}

	/**
	 * Verifica se está conectado ao servidor
	 */
	@Override
	public Boolean isConectado() {
		if (ftpClient != null) {
			return ftpClient.isAvailable() && ftpClient.isConnected();
		} else {
			return false;
		}
	}

	@Override
	public void desconectar() {
		if (ftpClient != null) {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				log.error("ERRO_COLMEIA_INESPERADO: Falha ao desconectar de cliente FTP: ", e);
			}
			super.desconectar();
		}
	}

	@Override
	public String receber(Map parametros) throws Exception {
		String statusRetorno = null;
		String pastaDestino = (String) parametros.get(PARAMETRO_AGENDAMENTO_PASTA_UPLOAD_ALTERNATIVO);
		if (pastaDestino == null) {
			pastaDestino = PASTA_ARQUIVO_USUARIO;
		}
		boolean sobrescreverArquivoLocal = new Boolean((String) parametros.get("sobrescreverArquivoLocal"));

		List<String> arquivosBaixados = new ArrayList<String>();
		try {
			for (Anexo anexo : this.getConn().getArquivos()) {
				log.info("Arquivo a receber via FTP: " + anexo.getNome());
			}
			if (conectar(parametros)) {
				ftpClient.enterLocalPassiveMode();
				if (this.getConn().getArquivos() != null) {
					statusRetorno = REGISTRO_SITUACAO_STATUS_RECEBIDO;
					for (Anexo anx : this.getConn().getArquivos()) {
						FileOutputStream out = null;
						String nomeArquivo = anx.getNome();
						try {

							String pathArquivoLocal = pastaDestino + System.getProperty(SYSTEM_FILE_SEPARATOR)
									+ nomeArquivo;

							File arquivoLocal = new File(pathArquivoLocal);

							if (!arquivoLocal.exists() || sobrescreverArquivoLocal) {
								out = new FileOutputStream(pathArquivoLocal);
								ftpClient.retrieveFile(
										ftpClient.printWorkingDirectory() + FTP_FILE_SEPARATOR + nomeArquivo, out);
								String retornoComando = this.processarResposta();
								if (REGISTRO_SITUACAO_STATUS_ERRO.equals(retornoComando)) {
									statusRetorno = retornoComando;
								}

								arquivosBaixados.add(nomeArquivo);
							}

						} catch (Exception e) {
							statusRetorno = REGISTRO_SITUACAO_STATUS_ERRO;
							log.error("ERRO_COLMEIA_INESPERADO: Erro no recebimento de arquivo FTP. URI: "
									+ getConn().getUri() + "Arquivo: " + nomeArquivo, e);
						} finally {
							if (out != null) {
								out.close();
							}
						}
					}
				} else {
					statusRetorno = REGISTRO_SITUACAO_STATUS_ERRO;
				}
			} else {
				statusRetorno = REGISTRO_SITUACAO_STATUS_ERRO;
			}
		} catch (Exception e) {
			log.error("ERRO_COLMEIA_INESPERADO: Erro no metodo ServidorFTP.receber: ", e);
			throw e;
		} finally {
			parametros.put("arquivosBaixados", arquivosBaixados);
			desconectar();
		}
		return statusRetorno;
	}

	/**
	 * retorna a lista de arquivos presentes no diretório de conexão. Necessario
	 * apos seu uso chamar o método desconectar
	 * 
	 * @param parametros
	 *            de conexao
	 * @param desconectarAoFinalizar
	 * 
	 */
	public Collection<String> listar(Map parametros, boolean desconectarAoFinalizar) throws Exception {
		Collection<String> listaArquivos = new ArrayList<String>();

		if (conectar(parametros)) {
			if (this.getConn().getArquivos() != null) {
				for (Anexo anx : this.getConn().getArquivos()) {
					FTPFile[] arquivosEncontrados = ftpClient.listFiles(anx.getNome());
					for (FTPFile file : arquivosEncontrados) {
						listaArquivos.add(file.getName());
					}
				}
			}
			if (desconectarAoFinalizar) {
				this.desconectar();
			}
		}
		return listaArquivos;
	}

	/**
	 * remove arquivo do FTP
	 * 
	 * @param parametros
	 *            de conexao
	 * 
	 * @return string sucesso
	 * @throws Exception
	 */
	public String remover(Map parametros) throws Exception {
		String statusRetorno = null;
		try {
			statusRetorno = REGISTRO_SITUACAO_STATUS_OPERACAO_EFETUADA_COM_SUCESSO;
			if (conectar(parametros)) {
				if (this.getConn().getArquivos() != null) {
					for (Anexo anx : this.getConn().getArquivos()) {
						ftpClient.deleteFile(anx.getNome());
						String retornoComando = this.processarResposta();
						if (REGISTRO_SITUACAO_STATUS_ERRO.equals(retornoComando)) {
							statusRetorno = retornoComando;
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("ERRO_COLMEIA_INESPERADO: Erro no metodo ServidorFTP.remover: ", e);
			statusRetorno = REGISTRO_SITUACAO_STATUS_ERRO;
		} finally {
			desconectar();
		}
		return statusRetorno;
	}

	/**
	 * move arquivo dentro do FTP, de u local para outro.
	 * 
	 * @param parametros
	 *            de conexao
	 * 
	 * @return string sucesso
	 * @throws Exception
	 */
	public String mover(Map parametros) throws Exception {
		String statusRetorno = REGISTRO_SITUACAO_STATUS_OPERACAO_EFETUADA_COM_SUCESSO;
		try {
			if (conectar(parametros)) {
				if (this.getConn().getArquivos() != null) {
					String destino = (String) parametros.get(PARAMETRO_FTP_DESTINO_ARQUIVO_NA_PORTAL);

					for (Anexo anx : this.getConn().getArquivos()) {
						ftpClient.rename(anx.getNome(), (destino + ServidorFTP.FTP_FILE_SEPARATOR) + anx.getNome());
						String retornoComando = this.processarResposta();
						if (REGISTRO_SITUACAO_STATUS_ERRO.equals(retornoComando)) {
							statusRetorno = retornoComando;
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("ERRO_COLMEIA_INESPERADO: Erro no metodo ServidorFTP.mover: ", e);
			statusRetorno = REGISTRO_SITUACAO_STATUS_ERRO;
		} finally {
			desconectar();
		}
		return statusRetorno;

	}

	/**
	 * Metodo responsavel por enviar o arquivo pelo ftp configurado na fase.
	 * 
	 * @param sb
	 * @param nomeArquivo
	 * @param pastaDestino
	 * @param faseExecucao
	 * 
	 * @throws ApplicationException
	 */
	public void enviarArquivoViaFTP(StringBuilder sb, String nomeArquivo, String pastaDestino,
			FaseExecucaoDTO faseExecucaoDTO) throws ApplicationValidatorException {

		try {
			String usuario = null;
			String endereco = null;
			String senha = null;
			String porta = null;

			List<Anexo> anexos = new ArrayList<Anexo>();
			Map<String, String> parametros = new HashMap<String, String>();
			String destino = "destino";
			parametros.put(destino, pastaDestino);

			if (faseExecucaoDTO != null && faseExecucaoDTO.getEnderecoTransmissao() != null) {
				usuario = faseExecucaoDTO.getUsuarioTransmissao();
				endereco = faseExecucaoDTO.getEnderecoTransmissao();
				senha = faseExecucaoDTO.getSenha();
				porta = faseExecucaoDTO.getPorta().toString();
			}

			Conexao conexao = new Conexao(REGISTRO_TIPO_TRANSMISSAO_FTP, usuario, senha, endereco, porta, null);

			conexao.setForma(TIPO_CAIXA_POSTAL_FORMA_ENVIAR);
			conexao.setId(new Long(1));
			conexao.setParametros(parametros);

			Anexo anexo = new Anexo();
			anexo.setNome(nomeArquivo);
			anexo.setArquivo(sb.toString().getBytes());
			anexos.add(anexo);
			conexao.setArquivos(anexos);

			ServidorFTP servidorFTP = new ServidorFTP(conexao);
			servidorFTP.enviar(parametros);
		} catch (ApplicationValidatorException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_SERVIDOR_FTP, e);
		}
	}

	private String processarResposta() throws ApplicationValidatorException {

		int codigoResposta = ftpClient.getReplyCode();
		int grupoCentena = codigoResposta / 100;

		switch (grupoCentena) {

		case 1:// Positive Preliminary reply
		case 2:// Positive Completion reply
		case 3:// Positive Intermediate reply
		{
			return REGISTRO_SITUACAO_STATUS_OPERACAO_EFETUADA_COM_SUCESSO;
		}

		case 4:// Transient Negative Completion reply
		case 5:// Permanent Negative Completion reply
		{
			log.warn(ftpClient.getReplyString());
			return REGISTRO_SITUACAO_STATUS_ERRO;
		}

		}
		throw new ApplicationValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_RESPOSTA_FTP,
				ftpClient.getReplyString());
	}
}