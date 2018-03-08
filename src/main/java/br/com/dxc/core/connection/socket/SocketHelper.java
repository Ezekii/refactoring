//package br.com.dxc.core.connection.socket;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.net.SocketException;
//import java.net.SocketTimeoutException;
//import java.net.UnknownHostException;
//import java.nio.BufferOverflowException;
//import java.nio.ByteBuffer;
//import java.nio.CharBuffer;
//import java.nio.charset.CharacterCodingException;
//import java.nio.charset.Charset;
//import java.nio.charset.CharsetDecoder;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.xsocket.connection.IBlockingConnection;
//
//import br.com.cresol.colmeia.core.Constantes;
//import br.com.cresol.colmeia.core.conf.AppConfig;
//import br.com.cresol.colmeia.core.conn.Conexao;
//import br.com.cresol.util.BoletoNPCUtil;
//
///**
// * Classe de Helper para obter uma conexao Client de Socket para qualquer
// * servidor e porta passados
// * 
// * Ao obter a conexao ela pode ser escrita pelo metodo IBlockingConnection.write
// * 
// * O metodo desconectar() deve ser chamado ao finalizar a escrita o pool
// * gerenciara as conexoes em Idle ou ativas
// * 
// * Para usar uma forma thread-safe o metodo enviarMensagem deve ser utilizado
// * 
// * @author Francisco Guerios
// * 
// * 14/03/2009
// * 
// */
//public class SocketHelper {
//
//	private static final String PAGAMENTO_BOLETO_NPC_SERVIDOR_PORTA = "pagamento.boleto.npc.servidor.porta";
//	private static final String PAGAMENTO_BOLETO_NPC_SERVIDOR_IP = "pagamento.boleto.npc.servidor.ip";
//	private static final String CODIFICACAO = "UTF-8";
//	private static Logger log = LoggerFactory.getLogger(SocketHelper.class);
//	private GerenciadorSocketPool gerenciador;
//
//	private IBlockingConnection bc = null;
//
//	public SocketHelper() {
//
//	}
//
//	public SocketHelper(Conexao conn) throws Exception {
//		this.conectar(conn);
//	}
//
//	/**
//	 * Conecta a um servidor de socket no conn.setUri() IP e conn.setPorta()
//	 * Porta do servidor
//	 * 
//	 * @param conn
//	 * @return
//	 * @throws Exception
//	 */
//	public IBlockingConnection conectar(Conexao conn) throws Exception {
//		if (bc == null) {
//			gerenciador = GerenciadorSocketPool.getGerenciadorSocketPool();
//			log.debug("Tentando conectar em " + conn);
//			try {
//				bc = gerenciador.getSocketPool().getBlockingConnection(
//						conn.getUri(), new Integer(conn.getPorta()));
//				bc.setEncoding(CODIFICACAO);
//			} catch (SocketTimeoutException e) {
//				log.debug(
//						"ERRO_COLMEIA_INESPERADO: Ocorreu um time out na conexao "
//								+ conn, e);
//				throw e;
//			}
//		}
//
//		return bc;
//	}
//
//	/**
//	 * Desconecta a conexao previamente conectada delegando ao pool a
//	 * responsabilidade de gerenciar a mesma
//	 * 
//	 */
//	public void desconectar() {
//		try {
//			if (bc.isOpen()) {
//				bc.close();
//			}
//		} catch (IOException e) {
//			try {
//				// se a conexao for invalida -> destroy it
//				// (nao vai retornar ao pool)
//				gerenciador.getSocketPool().destroy(bc);
//			} catch (Exception ignore) {
//				log.error("ERRO_COLMEIA_INESPERADO: ", e);
//			}
//		}
//	}
//
//	/**
//	 * Escreve no socket com thread-safe
//	 * 
//	 * @param msg
//	 * @throws IOException
//	 * @throws BufferOverflowException
//	 */
//	public void enviarMensagem(String msg) throws BufferOverflowException,
//			IOException {
//		// sincronizado pela instancia da conexao
//		synchronized (bc) {
//
//			bc.setAutoflush(false);
//
//			int written = bc.write(msg, CODIFICACAO);
//
//			bc.write(written); // efetivamente escreve
//
//			bc.flush();
//
//			// bc.close();
//
//			bc.setAutoflush(true);
//		}
//		log.debug("Mensagem enviada: " + msg);
//	}
//
//	/**
//	 * Envia e recebe o retorno de uma mensagem conforme
//	 * 
//	 * 
//	 * @param msg
//	 * @throws Exception
//	 */
//	public String enviarReceberMensagem(String msg) throws Exception {
//		try {
//			synchronized (bc) {
//				bc.setAutoflush(false);
//				// Enviando mensagem
//				int written = bc.write(msg, CODIFICACAO);
//				bc.write(written);
//				bc.flush();
//
//				bc.setAutoflush(true);
//				log.debug("Mensagem enviada: " + msg);
//
//				// Lendo resposta
//				ByteBuffer transferBuffer = ByteBuffer.allocate(4096);
//				int read = 0;
//
//				do {
//					bc.setEncoding(CODIFICACAO);
//
//					read = bc.read(transferBuffer);
//
//					transferBuffer.flip();
//
//					if (read > 0) {
//						bc.write(transferBuffer);
//					}
//				} while (read > 0);
//
//				String mensagemRecebida = this
//						.transformarMensagem(transferBuffer);
//				log.debug("Mensagem recebida: " + mensagemRecebida);
//
//				return mensagemRecebida;
//			}
//		} finally {
//			this.desconectar();
//		}
//	}
//
//	/**
//	 * Le do socket com thread-safe
//	 * 
//	 * Nao retorna imediatamente uma string pois de uma forma generica o retorno
//	 * pode nao ser uma string
//	 * 
//	 * Para transformar o ByteBuffer em String utilize o metodo
//	 * transformarMensagem desta classe
//	 * 
//	 * @return
//	 * @throws IOException
//	 */
//	public ByteBuffer receberMensagem() throws IOException {
//		// sincronizado pela instancia da conexao
//		synchronized (bc) {
//			ByteBuffer transferBuffer = ByteBuffer.allocate(4096);
//			int read = 0;
//
//			// read = bc.read(transferBuffer);
//
//			do {
//				bc.setEncoding(CODIFICACAO);
//
//				read = bc.read(transferBuffer);
//
//				transferBuffer.flip();
//
//				if (read > 0) {
//					// blocks until data is written into the os-level's
//					// SO_SNDBUF
//					bc.write(transferBuffer);
//				}
//			} while (read > 0);
//
//			// bc.flush();
//
//			return transferBuffer;
//		}
//
//	}
//
//	/**
//	 * Metodo utilitario para transformar um byteBuffer em String
//	 * 
//	 * que em teoria eh o padrao do Colmeia em comunicacoes
//	 * 
//	 * 
//	 * 
//	 * @param mensagem
//	 * @return
//	 * @throws CharacterCodingException
//	 */
//	public String transformarMensagem(ByteBuffer mensagem)
//			throws CharacterCodingException {
//		// Criar o decoder para ISO-8859-1
//		Charset charset = Charset.forName("ISO-8859-1");
//
//		CharsetDecoder decoder = charset.newDecoder();
//
//		CharBuffer cbuf = decoder.decode(mensagem);
//
//		return cbuf.toString();
//
//	}
//
//	/**
//	 * 
//	 * Este metodo finaliza a fila do Pool So deve ser chamado ao finalizar o
//	 * aplicativo e na finalizacao do Junit
//	 * 
//	 */
//	public void finalizaPool() {
//		gerenciador.finalizaPool();
//	}
//
//	private Socket getSocket(Long codCooperativa) throws UnknownHostException,
//			SocketException, IOException {
//		if (BoletoNPCUtil.executarNovaCobranca(codCooperativa)) {
//			return getSocket(
//					PAGAMENTO_BOLETO_NPC_SERVIDOR_IP,
//					PAGAMENTO_BOLETO_NPC_SERVIDOR_PORTA);
//		}
//		return getSocket(Constantes.SOCKET_POOL_SERVIDOR_IP,
//				Constantes.SOCKET_POOL_SERVIDOR_PORTA);
//	}
//
//	private Socket getSocket(String chaveIP,
//			String chavePorta) throws UnknownHostException, IOException,
//			SocketException {
//		Socket socket;
//		String ip = AppConfig.getConfiguracao(chaveIP);
//		Integer porta = Integer.parseInt(AppConfig.getConfiguracao(chavePorta));
//
//		Integer timeOut = Integer.parseInt(AppConfig
//				.getConfiguracao(Constantes.SOCKET_TIMEOUT));
//
//		InetAddress addr = InetAddress.getByName(ip);
//
//		// Criando socket
//		socket = new Socket(addr, porta);
//
//		socket.setSoTimeout(timeOut);
//		return socket;
//	}
//	/**
//	 * Envia e recebe o retorno de uma mensagem conforme padrao do GCB, mas sem
//	 * utilizar a infra-estrutura de Pool, ou seja, este m�todo tamb�m abre e
//	 * fecha uma simples conexao socket.
//	 * 
//	 * @author Thiago da Silva Lino
//	 * 
//	 * @param mensagem
//	 * @return retorno do servidor
//	 * 
//	 * @throws Exception
//	 */
//	public String enviarEReceberMensagemSemPool(String mensagem,
//			Long codCooperativa)
//			throws Exception {
//		Socket socket = null;
//		BufferedWriter wr = null;
//		BufferedReader rd = null;
//
//		try {
//			socket = getSocket(codCooperativa);
//
//			// escrever
//			wr = new BufferedWriter(new OutputStreamWriter(socket
//					.getOutputStream(), "ISO-8859-1"));
//			wr.write(mensagem);
//			wr.flush();
//
//			// ler
//			rd = new BufferedReader(new InputStreamReader(socket
//					.getInputStream(), "ISO-8859-1"));
//
//			CharBuffer target = CharBuffer.allocate(4096);// (2048);
//
//			rd.read(target);
//
//			target.rewind();
//
//			return target.toString().trim();
//		} catch (Exception e) {
//			log.error("ERRO_COLMEIA_INESPERADO: ", e);
//			throw e;
//		} finally {
//			if (socket != null) {
//				rd.close();
//				wr.close();
//				socket.close();
//			}
//		}
//	}
//}
