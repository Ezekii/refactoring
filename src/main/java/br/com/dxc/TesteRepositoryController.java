package br.com.dxc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dxc.model.Teste;
import br.com.dxc.repository.TesteRepository;

@RestController
@RequestMapping("/repo")
public class TesteRepositoryController {
	
	@Autowired
	TesteRepository testeRepository;

	@GetMapping("/testes")
	public List<Teste> getAllTestes() {
		return testeRepository.findAll();
	}
	
	@GetMapping("/testes/{id}")
	public ResponseEntity<Teste> getTesteById(@PathVariable(value = "id") Long id) {
		Teste teste = testeRepository.findOne(id);
		return teste == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(teste);
	}
	
	@PostMapping("/testes")
	public Teste createTeste(@Valid @RequestBody Teste teste) {
	    return testeRepository.save(teste);
	}
	
	@PutMapping("/testes/{id}")
	public ResponseEntity<Teste> updateTeste(@PathVariable(value = "id") Long id, @Valid @RequestBody Teste testeDetails) {
	    Teste teste = testeRepository.findOne(id);
	    if(teste == null) {
	        return ResponseEntity.notFound().build();
	    }
	    teste.setNome(testeDetails.getNome());

	    Teste updatedTeste = testeRepository.save(teste);
	    return ResponseEntity.ok(updatedTeste);
	}
	
	@DeleteMapping("/testes/{id}")
	public ResponseEntity<Teste> deleteTeste(@PathVariable(value = "id") Long id) {
		Teste teste = testeRepository.findOne(id);
	    if(teste == null) {
	        return ResponseEntity.notFound().build();
	    }

	    testeRepository.delete(teste);
	    return ResponseEntity.ok().build();
	}

}