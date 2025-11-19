package br.com.senai.backend.sistema_mercado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.sistema_mercado.models.Funcionario;
import br.com.senai.backend.sistema_mercado.services.FuncionarioServices;


@RestController
@RequestMapping ("/Funcionario")
public class FuncionarioController {

@Autowired
private FuncionarioServices funcionarioServices;

@PostMapping("/Salvar")
public Funcionario salvar(@RequestBody Funcionario funcionario){
    return funcionarioServices.cadastrar(funcionario);
}

     @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Integer id) {
        return funcionarioServices.recuperarPorId(id);
    }
    
}
