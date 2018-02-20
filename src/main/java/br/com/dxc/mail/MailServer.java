package br.com.dxc.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailServer {

	@Autowired
	public JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) {
		if (to == null || subject == null) {
//			log.error("Para :" + this.getConn().getPara());
//			log.error("Assunto :" + this.getConn().getAssunto());
//			log.error("O parametro informado na conex�o � inv�lido. N�o � poss�vel enviar o email." + this.getConn());
			return;
		}
		SimpleMailMessage message = new SimpleMailMessage(); 
		message.setTo(to); 
		message.setSubject(subject); 
		message.setText(text);
		
		try {
			emailSender.send(message);
		} catch (Exception e) {
			// log.error("ERRO_COLMEIA_INESPERADO: ", e);
			e.printStackTrace();
		}
	}
	
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
		
		MimeMessage message = emailSender.createMimeMessage();
		
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			
			FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
			helper.addAttachment(file.getFilename(), file);
		} catch (MessagingException e) {
			// log.error("ERRO_COLMEIA_INESPERADO: ", e);
			e.printStackTrace();
			return;
		}
		
		try {
			emailSender.send(message);
		} catch (Exception e) {
			// log.error("ERRO_COLMEIA_INESPERADO: ", e);
			e.printStackTrace();
		}
	}
	
}
