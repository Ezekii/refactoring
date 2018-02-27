package br.com.dxc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dxc.repository.TesteRepository;

@RestController
public class HelloController {
	
	@Autowired
	TesteRepository testeRepository;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
}