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

import br.com.senai.backend.sistema_mercado.models.Mercadoria;
import br.com.senai.backend.sistema_mercado.services.MercadoriaServices;


@RestController
@RequestMapping("/mercadoria")
public class MercadoriaController {

    @Autowired
    private MercadoriaServices mercadoriaServices;

    // Salvar
    @PostMapping("/salvar")
    public Mercadoria salvar(@RequestBody Mercadoria mercadoria){
        return mercadoriaServices.cadastrar(mercadoria);
    }

    // PUT - Atualizar
    @PutMapping("/atualizar/{id}")
    public Mercadoria atualizar(@PathVariable Integer id, @RequestBody Mercadoria mercadoria){
        return mercadoriaServices.atualizar(id, mercadoria);
    }

    // Get - LISTAR TODOS
    @GetMapping("/listar-todos")
    public List<Mercadoria> listarTodos(){
        return mercadoriaServices.listarTodos();
    }

     @GetMapping("/recuperar-por-id/{id}")
    public Mercadoria recuperarPorId(@PathVariable Integer id) {
        return mercadoriaServices.recuperarPorId(id);
    }

        // Delete - REMOVER
    @DeleteMapping("/delete{id}")
    public String removerPorId(@PathVariable Integer id){
        if(mercadoriaServices.removerPorId(id)){
            return "Mercadoria removida com sucesso!";
        }
        return "Falha ao remover mercadoria.";
    } 
}
