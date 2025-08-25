package com.gerenciamento.funcionarios.pietro.service;

import com.gerenciamento.funcionarios.pietro.model.Departamento;
import com.gerenciamento.funcionarios.pietro.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository depto_repository;

    public Departamento buscarPorId(UUID id){
        return depto_repository.findById(id).orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
    }

    public Departamento salvarDepartamento(Departamento departamento){
        return depto_repository.save(departamento);
    }

    public Departamento atualizarDepartamento(UUID id,Departamento departamento){
        Departamento existente = buscarPorId(id);
        existente.setNome_depto(departamento.getNome_depto());

        return depto_repository.save(existente);
    }

    public void deletarDepartamento(UUID id){
        depto_repository.deleteById(id);
    }


}
