package br.com.senai.backend.sistema_mercado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.sistema_mercado.models.Mercadoria;
import br.com.senai.backend.sistema_mercado.services.MercadoriaServices;


@RestController
@RequestMapping("/Mercadoria")
public class MercadoriaController {

    @Autowired
    private MercadoriaServices mercadoriaServices;

    @PostMapping("/Salvar")
    public Mercadoria salvar(@RequestBody Mercadoria mercadoria){
        return mercadoriaServices.cadastrar(mercadoria);
    }

    // Get - LISTAR TODOS
    @GetMapping("/Listar Todos")
    public List<Mercadoria> listarTodos(){
        return mercadoriaServices.listarTodos();
    }

     @GetMapping("/{id}")
    public Mercadoria buscarPorId(@PathVariable Integer id) {
        return mercadoriaServices.recuperarPorId(id);
    }

        // Delete - REMOVER
    @DeleteMapping("/Delete{id}")
    public void remover(@PathVariable Integer id){
        mercadoriaServices.remover(id);
    } 
}
