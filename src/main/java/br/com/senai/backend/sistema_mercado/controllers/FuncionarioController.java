package br.com.senai.backend.sistema_mercado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.sistema_mercado.models.Funcionario;
import br.com.senai.backend.sistema_mercado.services.FuncionarioServices;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping ("/Funcionario")
public class FuncionarioController {

@Autowired
private FuncionarioServices funcionarioServices;

@PostMapping("/Salvar")
public Funcionario salvar(@RequestBody Funcionario funcionario){
    return funcionarioServices.cadastrar(funcionario);
}
    
}
