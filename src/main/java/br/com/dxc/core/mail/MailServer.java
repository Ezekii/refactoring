package br.com.dxc.core.mail;
//package br.com.dxc.mail;
//
//import java.io.File;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import br.com.cresol.colmeia.core.exception.ApplicationException;
//import br.com.dxc.exception.ApplicationBusinessExceptionCode;
//import br.com.dxc.exception.BusinessValidatorException;
//import br.com.dxc.logging.LogBuilder;
//import br.com.dxc.util.Assert;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Service
//public class MailServer {
//
//	@Autowired
//	public JavaMailSender emailSender;
//
//	@Autowired
//	public Logger logger = LoggerFactory.getLogger(MailServer.class);
//
//	/**
//	 * @param to
//	 * @param subject
//	 * @param text
//	 * @return
//	 * @throws ApplicationException
//	 */
//	public void sendSimpleMessage(String to, String subject, String text) throws ApplicationException {
//
//		Assert.notNull(to, ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_EMAIL, "to");
//		Assert.notNull(subject, ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_EMAIL, "subject");
//
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(to);
//		message.setSubject(subject);
//		message.setText(text);
//
//		try {
//			this.emailSender.send(message);
//		} catch (Exception e) {
//			String mensagem = LogBuilder
//					.create(ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE.getDescricao()).payload("to", to)
//					.payload("subject", subject).payload("text", text).build();
//			logger.error(mensagem, e);
//			throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE, e);
//		}
//	}
//
//	/**
//	 * @param to
//	 * @param subject
//	 * @param text
//	 * @param pathToAttachment
//	 * @return
//	 * @throws ApplicationException
//	 */
//	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment)
//			throws ApplicationException {
//
//		Assert.notNull(to, ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_EMAIL, "to");
//		Assert.notNull(subject, ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_EMAIL, "subject");
//		Assert.notNull(pathToAttachment, ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_EMAIL, "pathToAttachment");
//
//		MimeMessage message = this.emailSender.createMimeMessage();
//
//		MimeMessageHelper helper;
//		try {
//			helper = new MimeMessageHelper(message, true);
//
//			helper.setTo(to);
//			helper.setSubject(subject);
//			helper.setText(text);
//
//			FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
//			helper.addAttachment(file.getFilename(), file);
//
//		} catch (MessagingException e) {
//			String mensagem = LogBuilder
//					.create(ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE.getDescricao()).payload("to", to)
//					.payload("subject", subject).payload("text", text).payload("pathToAttachment", pathToAttachment)
//					.build();
//			logger.error(mensagem, e);
//			throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE, e);
//		}
//		try {
//			this.emailSender.send(message);
//		} catch (Exception e) {
//			String mensagem = LogBuilder
//					.create(ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE.getDescricao()).payload("to", to)
//					.payload("subject", subject).payload("text", text).payload("pathToAttachment", pathToAttachment)
//					.build();
//			logger.error(mensagem, e);
//			throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE, e);
//		}
//	}
//
//}
