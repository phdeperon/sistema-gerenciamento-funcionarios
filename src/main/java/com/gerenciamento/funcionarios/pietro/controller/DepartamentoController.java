package com.gerenciamento.funcionarios.pietro.controller;

import com.gerenciamento.funcionarios.pietro.model.Departamento;
import com.gerenciamento.funcionarios.pietro.repository.DepartamentoRepository;
import com.gerenciamento.funcionarios.pietro.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @PostMapping
    public Departamento criarDepartamento(@RequestBody Departamento departamento){
        return service.salvarDepartamento(departamento);
    }

    @PutMapping
    public Departamento atualizarDepartamento(@PathVariable UUID id,@RequestBody Departamento departamento){
        return service.atualizarDepartamento(id,departamento);
    }

    @DeleteMapping
    public void deletarDepartamento(@PathVariable UUID id){
        service.deletarDepartamento(id);
    }

    @GetMapping
    public Departamento buscarPorId(@PathVariable UUID id){
        return service.buscarPorId(id);
    }


}
