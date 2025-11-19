package br.com.senai.backend.sistema_mercado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.sistema_mercado.models.Funcionario;
import br.com.senai.backend.sistema_mercado.services.FuncionarioServices;


@RestController
@RequestMapping ("/funcionario")
public class FuncionarioController {

@Autowired
private FuncionarioServices funcionarioServices;

    // Salvar
    @PostMapping("/salvar")
    public Funcionario salvar(@RequestBody Funcionario funcionario){
        return funcionarioServices.cadastrar(funcionario);
    }

    // PUT - Atualizar
    @PutMapping("/atualizar/{id}")
    public Funcionario atualizar(@PathVariable Integer id, @RequestBody Funcionario funcionario){
        return funcionarioServices.atualizar(id, funcionario);
    }

    // Get - LISTAR TODOS
    @GetMapping("/listar-todos")
    public List<Funcionario> listarTodos(){
        return funcionarioServices.listarTodos();
    }

     @GetMapping("/recuperar-por-id/{id}")
    public Funcionario recuperarPorId(@PathVariable Integer id) {
        return funcionarioServices.recuperarPorId(id);
    }

        // Delete - REMOVER
    @DeleteMapping("/delete{id}")
    public String removerPorId(@PathVariable Integer id){
        if(funcionarioServices.removerPorId(id)){
            return "Funcionario removido com sucesso!";
        }
        return "Falha ao remover funcionario.";
    } 
}
