package br.com.senai.backend.sistema_mercado.services;

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

    public Funcionario recuperarPorId (Integer id){
        return funcionarioRepository.findById(id).get();
    }
    public void remover(Integer id) { // Metodo para remover um carro pelo id
    funcionarioRepository.deleteById(id); // delete from carro where id = ?
    }
}
