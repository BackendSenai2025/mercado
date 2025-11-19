package br.com.senai.backend.sistema_mercado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.sistema_mercado.models.Funcionario;
import br.com.senai.backend.sistema_mercado.repositories.FuncionarioRepository;

@Service
public class FuncionarioServices {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

     public Funcionario cadastrar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    
    public Funcionario atualizar(Integer id, Funcionario funcionario) {
        Funcionario func = funcionarioRepository.findById(id).get();
        if(func != null){
        funcionario.setId(func.getId());
        return funcionarioRepository.save(funcionario);
        }
        return null;
    }
        //funcionario.setId(id);
        //return funcionarioRepository.save(funcionario);
    
    public boolean existe(Integer id) {
        return funcionarioRepository.existsById(id);
    }
    
    public List<Funcionario> listarTodos() {  // Metodo para listar todos os carros
        return funcionarioRepository.findAll(); // select * from carro
    }

    public Funcionario recuperarPorId (Integer id){
        return funcionarioRepository.findById(id).get();
    }
    public boolean removerPorId(Integer id){
        Funcionario func = funcionarioRepository.findById(id).get();
        if (func != null) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
    //public void remover(Integer id) { // Metodo para remover um carro pelo id
    //funcionarioRepository.deleteById(id); // delete from carro where id = ?
    //}
}
