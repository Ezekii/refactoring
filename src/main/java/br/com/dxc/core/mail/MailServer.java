package br.com.dxc.core.mail;

import java.io.File;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.dxc.exception.ApplicationBusinessExceptionCode;
import br.com.dxc.exception.BusinessValidatorException;
import br.com.dxc.logging.LogBuilder;

@Service
public class MailServer {

	@Autowired
	public JavaMailSender emailSender;

	public Logger logger = LoggerFactory.getLogger(MailServer.class);

	/**
	 * @param to
	 * @param subject
	 * @param text
	 * @return
	 */
	public void sendSimpleMessage(String to, String subject, String text) {
		
		Optional.ofNullable(to).orElseThrow(() -> new BusinessValidatorException(
				ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE_PARAMETER, "to"));
		Optional.ofNullable(subject).orElseThrow(() -> new BusinessValidatorException(
				ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE_PARAMETER, "subject"));

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);

		try {
			this.emailSender.send(message);
		} catch (Exception e) {
			String mensagem = LogBuilder.create(ApplicationBusinessExceptionCode.CRESOL_LOG_SEND_MESSAGE.getDescricao())
					.payload("to", to).payload("subject", subject).payload("text", text).build();
			logger.error(mensagem, e);
			throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE, e);
		}
	}

	/**
	 * @param to
	 * @param subject
	 * @param text
	 * @param pathToAttachment
	 */
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {

		Optional.ofNullable(to).orElseThrow(() -> new BusinessValidatorException(
				ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE_PARAMETER, "to"));
		Optional.ofNullable(subject).orElseThrow(() -> new BusinessValidatorException(
				ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE_PARAMETER, "subject"));
		Optional.ofNullable(pathToAttachment).orElseThrow(() -> new BusinessValidatorException(
				ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE_PARAMETER, "pathToAttachment"));

		MimeMessage message = this.emailSender.createMimeMessage();

		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);

			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);

			FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
			helper.addAttachment(file.getFilename(), file);

		} catch (MessagingException e) {
			String mensagem = LogBuilder.create(ApplicationBusinessExceptionCode.CRESOL_LOG_SEND_MESSAGE.getDescricao())
					.payload("to", to).payload("subject", subject).payload("text", text)
					.payload("pathToAttachment", pathToAttachment).build();
			logger.error(mensagem, e);
			throw new BusinessValidatorException(
					ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE_PATH_TO_ATTACHMENT, e);
		}
		try {
			this.emailSender.send(message);
		} catch (Exception e) {
			String mensagem = LogBuilder.create(ApplicationBusinessExceptionCode.CRESOL_LOG_SEND_MESSAGE.getDescricao())
					.payload("to", to).payload("subject", subject).payload("text", text)
					.payload("pathToAttachment", pathToAttachment).build();
			logger.error(mensagem, e);
			throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_SEND_MESSAGE, e);
		}
	}

}
