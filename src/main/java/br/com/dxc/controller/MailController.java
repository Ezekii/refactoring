//package br.com.dxc.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import br.com.cresol.colmeia.core.exception.ApplicationException;
//import br.com.dxc.dto.MailDTO;
//import br.com.dxc.mail.MailServer;
//
//@Controller
//@RequestMapping("/mail")
//public class MailController {
//
//	@Autowired
//	public MailServer mailServer;
//
//	@RequestMapping(value = "/sendTest", method = RequestMethod.GET)
//	public String createMail() throws ApplicationException {
//		mailServer.sendSimpleMessage("ezekii.post@gmail.com", "teste", "aeHOO");
//
//		return "redirect:/dxc";
//	}
//
//	@RequestMapping(value = "/send", method = RequestMethod.POST)
//	public String createMail(Model model, @ModelAttribute("mailObject") @Valid MailDTO mailDTO) throws ApplicationException {
//		this.mailServer.sendSimpleMessage(mailDTO.getTo(), mailDTO.getSubject(), mailDTO.getText());
//		return "ok";
//
//	}
//
//	@RequestMapping(value = "/sendAttachment", method = RequestMethod.POST)
//	public String createMailWithAttachment(Model model, @ModelAttribute("mailObject") @Valid MailDTO mailDTO) throws ApplicationException {
//		this.mailServer.sendMessageWithAttachment(mailDTO.getTo(), mailDTO.getSubject(), mailDTO.getText(),
//				mailDTO.getAttachmentPath());
//		return "ok";
//	}
//}
