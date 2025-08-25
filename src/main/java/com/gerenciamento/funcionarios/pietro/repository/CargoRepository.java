package com.gerenciamento.funcionarios.pietro.repository;

import com.gerenciamento.funcionarios.pietro.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CargoRepository extends JpaRepository<Cargo, UUID> {
}
