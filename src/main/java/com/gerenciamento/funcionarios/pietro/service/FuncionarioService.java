package com.gerenciamento.funcionarios.pietro.service;

import com.gerenciamento.funcionarios.pietro.model.Cargo;
import com.gerenciamento.funcionarios.pietro.model.Departamento;
import com.gerenciamento.funcionarios.pietro.model.Funcionario;
import com.gerenciamento.funcionarios.pietro.repository.CargoRepository;
import com.gerenciamento.funcionarios.pietro.repository.DepartamentoRepository;
import com.gerenciamento.funcionarios.pietro.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Funcionario salvarFuncionario(Funcionario funcionario){
        UUID cargoId = funcionario.getCargo().getId();
        Cargo cargo = cargoRepository.findById(cargoId)
                .orElseThrow(() -> new RuntimeException("Cargo não encontrado"));

        UUID deptoId = funcionario.getDepartamento().getId();
        Departamento departamento = departamentoRepository.findById(deptoId)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        funcionario.setCargo(cargo);
        funcionario.setDepartamento(departamento);


        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionario(UUID id){
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizarFuncionario(UUID id, Funcionario funcionario){
        Funcionario existente = buscarPorId(id);

        existente.setNome(funcionario.getNome());
        existente.setIdade(funcionario.getIdade());
        existente.setSalario(funcionario.getSalario());
        existente.setCargo(funcionario.getCargo());
        existente.setDepartamento(funcionario.getDepartamento());

        return funcionarioRepository.save(existente);
    }

    public List<Funcionario> buscarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(UUID id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public List<Funcionario> buscarPorDepartamento(UUID id_depto){
        return funcionarioRepository.findByDepartamentoId(id_depto);
    }

    public List<Funcionario> buscarPorCargo(UUID id_cargo){
        return funcionarioRepository.findByCargoId(id_cargo);
    }


}
