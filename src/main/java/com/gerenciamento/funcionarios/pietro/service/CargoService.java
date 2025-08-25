package com.gerenciamento.funcionarios.pietro.service;

import com.gerenciamento.funcionarios.pietro.model.Cargo;
import com.gerenciamento.funcionarios.pietro.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public Cargo buscarPorId(UUID id){
        return cargoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cargo não encontrado!"));
    }

    public List<Cargo> buscarTodos(){
        return cargoRepository.findAll();
    }

    public Cargo salvarCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public void deletarCargo(UUID id){
         cargoRepository.deleteById(id);
    }

    public Cargo atualizarCargo(UUID id,Cargo cargo){
        Cargo existente = buscarPorId(id);
        existente.setNomeCargo(cargo.getNomeCargo());
        existente.setDescricao(cargo.getDescricao());

        return cargoRepository.save(existente);
    }
}
