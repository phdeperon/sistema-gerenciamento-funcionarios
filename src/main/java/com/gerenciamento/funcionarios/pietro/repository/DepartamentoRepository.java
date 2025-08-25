package com.gerenciamento.funcionarios.pietro.repository;

import com.gerenciamento.funcionarios.pietro.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartamentoRepository extends JpaRepository<Departamento, UUID> {
}
