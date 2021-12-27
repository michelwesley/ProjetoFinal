package br.grupo01.springboot01.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.grupo01.springboot01.model.Conta;



@Repository
public interface ContaRepo extends CrudRepository<Conta, Integer> { 
    public List<Conta> findByAgenciaGreaterThanEqual(int agencia);

}
