package br.com.senai.backend.sistema_mercado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.sistema_mercado.models.Mercadoria;
import br.com.senai.backend.sistema_mercado.repositories.MercadoriaRepository;

@Service
public class MercadoriaServices {

    @Autowired
    private MercadoriaRepository mercadoriaRepository;

    public Mercadoria cadastrar(Mercadoria mercadoria)  {
        return mercadoriaRepository.save(mercadoria);
    }

    public Mercadoria atualizar(Integer id, Mercadoria mercadoria) {
        Mercadoria merc = mercadoriaRepository.findById(id).get();
        if(merc != null){
        mercadoria.setId(merc.getId());
        return mercadoriaRepository.save(mercadoria);
        }
        return null;
    }
    //mercadoria.setId(id);
    //return mercadoriaRepository.save(mercadoria);
    
    public boolean existe(Integer id) {
        return mercadoriaRepository.existsById(id);
    }

    public List<Mercadoria> listarTodos() {  
        return mercadoriaRepository.findAll(); 
    }

    public Mercadoria recuperarPorId(Integer id){
        return mercadoriaRepository.findById(id).get();
    }

    public boolean removerPorId(Integer id){
        Mercadoria merc = mercadoriaRepository.findById(id).get();
        if (merc != null) {
            mercadoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    //public void remover(Integer id) { // Metodo para remover um carro pelo id
    //mercadoriaRepository.deleteById(id); // delete from carro where id = ?
    //}
}
