package br.com.dxc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dxc.model.Teste;

public interface TesteRepository extends CrudRepository<Teste, Long> {

    List<Teste> findByNome(String nome);
    
    List<Teste> findAll();
}