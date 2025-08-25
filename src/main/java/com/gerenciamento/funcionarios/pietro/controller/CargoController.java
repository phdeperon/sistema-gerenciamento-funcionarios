package com.gerenciamento.funcionarios.pietro.controller;

import com.gerenciamento.funcionarios.pietro.model.Cargo;
import com.gerenciamento.funcionarios.pietro.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping
    public Cargo criarCargo(@RequestBody Cargo cargo){
        return cargoService.salvarCargo(cargo);
    }

    @GetMapping
    public List<Cargo> listarCargos(){
        return cargoService.buscarTodos();
    }

    @PutMapping
    public Cargo atualizarCargo(@PathVariable UUID id,@RequestBody Cargo cargo){
        return cargoService.atualizarCargo(id, cargo);
    }

    @DeleteMapping
    public void deletarCargo(@PathVariable UUID id){
        cargoService.deletarCargo(id);
    }


}
