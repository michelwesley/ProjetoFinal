package br.grupo01.springboot01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.grupo01.springboot01.model.Conta;
import br.grupo01.springboot01.repository.ContaRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/conta")
public class ContaController {

  @Autowired
  private ContaRepo repo;

  @GetMapping
  public List<Conta> listarTodos() {
    return (List<Conta>) repo.findAll();
  }

  @GetMapping("/agencia/{ag}")
  public List<Conta> listarAgencia(@PathVariable int ag) {

    return repo.findByAgenciaGreaterThanEqual(ag);

  }

}
