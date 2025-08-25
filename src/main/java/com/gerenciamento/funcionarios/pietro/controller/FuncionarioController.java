package com.gerenciamento.funcionarios.pietro.controller;

import com.gerenciamento.funcionarios.pietro.model.Funcionario;
import com.gerenciamento.funcionarios.pietro.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.salvarFuncionario(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable UUID id,@RequestBody Funcionario funcionario){
        return funcionarioService.atualizarFuncionario(id,funcionario);
    }

    @DeleteMapping("{id}")
    public void deletarFuncionario(@PathVariable UUID id){
        funcionarioService.deletarFuncionario(id);
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios(){
        return funcionarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable UUID id){
        return funcionarioService.buscarPorId(id);
    }
    @GetMapping("/departamento/{id}")
    public List<Funcionario> buscarPorDepartamento(@PathVariable UUID id){
        return funcionarioService.buscarPorDepartamento(id);
    }

    @GetMapping("/cargo/{id}")
    public List<Funcionario> buscarPorCargo(@PathVariable UUID id){
        return funcionarioService.buscarPorCargo(id);
    }


}
