package br.com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dxc.jms.producer.Sender;

@Controller
@RequestMapping("/jms")
public class JmsController {

	@Autowired
	private Sender sender;
	
	@RequestMapping(value = "/sendTest", method = RequestMethod.GET)
	public String createMail() {
		sender.send("helloworld.q", "vamou!");
		
		return "redirect:/dxc";
	}
}
