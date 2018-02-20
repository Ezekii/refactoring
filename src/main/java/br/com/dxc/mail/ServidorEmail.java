//package br.com.dxc;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Date;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.activation.DataHandler;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import javax.mail.util.ByteArrayDataSource;
//
//import br.com.cresol.colmeia.administracao.ConstantesAdministracao;
//import br.com.cresol.colmeia.core.conf.AppConfig;
//import br.com.cresol.colmeia.core.conn.Anexo;
//import br.com.cresol.colmeia.core.conn.Conexao;
//import br.com.cresol.colmeia.core.conn.servidor.auth.MailAuth;
//
///**
// * Abstra��o respons�vel em enviar um email atrav�s de um objeto conex�o com
// * seus anexos
// * 
// * @author Francisco Zenni Guerios
// * 
// * 
// * 28/08/2007
// */
//public class ServidorEmail extends Servidor {
//
//	private static String MAIL_SERVER = AppConfig
//			.getConfiguracao("servidor_smtp_ip");
//
//	private static String MAIL_SERVER_NAME = AppConfig
//			.getConfiguracao("servidor_smtp");
//
//	private static String MAIL_FROM = AppConfig
//			.getConfiguracao("servidor_smtp_usuario");
//
//	private static String MAIL_SENHA = AppConfig
//			.getConfiguracao("servidor_smtp_senha");
//
//	// private static String MAIL_SERVER = "10.90.2.10";
//
//	// private static String MAIL_SERVER_NAME = "confesol.com.br";
//
//	// private static String MAIL_FROM = "colmeia";
//
//	// private static String MAIL_SENHA = "colmeia";
//
//	private MimeMessage msg;
//
//	public static String charset = "iso-8859-1";
//
//	public ServidorEmail(Conexao conn) {
//		super(conn);
//	}
//
//	@Override
//	public Boolean conectar(Map parametros) {
//		// log.debug("Tentando conectar ao servidor de email.");
//		if (this.getConn().getPara() == null
//				|| this.getConn().getAssunto() == null) {
//			log.error("Para :" + this.getConn().getPara());
//			log.error("Assunto :" + this.getConn().getAssunto());
//			log.error("O parametro informado na conex�o � inv�lido. N�o � poss�vel enviar o email." + this.getConn());
//
//			return false;
//		}
//		Properties props = new Properties();
//		props.put("mail.smtp.host", MAIL_SERVER);
//		props.put("mail.smtp.auth", "true");
//		MailAuth auth = new MailAuth(MAIL_FROM, MAIL_SENHA);
//		Session session = Session.getInstance(props, auth);
//		if (log != null) {
//			session.setDebug(log.isDebugEnabled());
//		}
//		msg = new MimeMessage(session);
//		try {
//			msg
//					.setFrom(new InternetAddress(MAIL_FROM + "@"
//							+ MAIL_SERVER_NAME));
//
//			msg.setRecipients(Message.RecipientType.TO, this.getConn()
//					.getPara());
//			msg.setSubject(this.getConn().getAssunto(), charset);
//			msg.setSentDate(new Date());
//			MimeBodyPart mbpTexto = new MimeBodyPart();
//			if (this.getConn().getCorpo() != null) {
//				mbpTexto.setText(this.getConn().getCorpo().toString(), charset);
//			} else {
//				// O corpo � o mesmo do assunto pois o objetivo � enviar email
//				// com
//				// anexo
//				mbpTexto.setText(this.getConn().getAssunto(), charset);
//			}
//
//			mbpTexto.addHeader("Content-Type", "text/html");
//			mbpTexto.addHeader("charset", charset);
//
//			Multipart mp = new MimeMultipart();
//			mp.addBodyPart(mbpTexto);
//			anexaArquivos(mp);
//			msg.setContent(mp);
//			// log.debug("Mensagem de email montada.");
//		} catch (AddressException e) {
//			log.error("ERRO_COLMEIA_INESPERADO: ", e);
//			throw new RuntimeException(e);
//		} catch (MessagingException e) {
//			log.error("ERRO_COLMEIA_INESPERADO: ", e);
//			throw new RuntimeException(e);
//		} catch (IOException e) {
//			log.error("ERRO_COLMEIA_INESPERADO: ", e);
//			throw new RuntimeException(e);
//		}
//		return true;
//	}
//
//	/**
//	 * Anexa os arquivos que vieram na conex�o
//	 * 
//	 * @param mp
//	 * @throws MessagingException
//	 * @throws IOException
//	 */
//	private void anexaArquivos(Multipart mp) throws MessagingException,
//			IOException {
//		if (this.getConn().getArquivos() != null) {
//			for (Anexo anx : this.getConn().getArquivos()) {
//				MimeBodyPart mbpAnexo = new MimeBodyPart();
//				mbpAnexo.setFileName(anx.getNome());
//				InputStream objeto = new ByteArrayInputStream(anx.getArquivo());
//				mbpAnexo.setDataHandler(carregaArquivo(anx.getNome(), objeto));
//				objeto.close();
//				mp.addBodyPart(mbpAnexo);
//			}
//			// log.debug("Arquivos anexados.");
//		}
//	}
//
//	/**
//	 * Indica o arquivo com o seu mime/type Mimes suportados PDF, ZIP, XML, TXT,
//	 * HTML
//	 * 
//	 * @param nome
//	 * @param file
//	 * @return DataHandler
//	 * @throws IOException
//	 */
//	private DataHandler carregaArquivo(String nome, InputStream file)
//			throws IOException {
//
//		String ext = nome.substring(nome.indexOf(".") + 1);
//		String mime = "text/plain";
//		if ("pdf".equals(ext)) {
//			mime = "application/pdf";
//		} else if ("zip".equals(ext)) {
//			mime = "application/zip";
//		} else if ("xml".equals(ext)) {
//			mime = "text/xml";
//		} else if ("txt".equals(ext)) {
//			mime = "text/plain";
//		} else if ("html".equals(ext)) {
//			mime = "text/html";
//		} else if ("jar".equals(ext)) {
//			mime = "application/jar";
//		}
//		return new DataHandler(new ByteArrayDataSource(file, mime));
//	}
//
//	@Override
//	public String enviar(Map param) {
//		try {
//			if (conectar(param)) {
//				// log.debug("Enviando email....");
//
//				Transport.send(msg);
//				// log.debug("Email enviado.");
//				desconectar();
//				// log.debug("Cliente de email desconectado.");
//				return ConstantesAdministracao.REGISTRO_SITUACAO_STATUS_ENVIADO;
//			} else
//				return ConstantesAdministracao.REGISTRO_SITUACAO_STATUS_ERRO;
//
//		} catch (Exception e) {
//			log.error("ERRO_COLMEIA_INESPERADO: ", e);
//			return ConstantesAdministracao.REGISTRO_SITUACAO_STATUS_ERRO;
//		}
//	}
//
//	@Override
//	public Boolean isConectado() {
//		return false;
//	}
//
//	@Override
//	public String receber(Map param) {
//		return ConstantesAdministracao.REGISTRO_SITUACAO_STATUS_ERRO;
//	}
//
//}
