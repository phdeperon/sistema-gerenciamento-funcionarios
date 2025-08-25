package com.gerenciamento.funcionarios.pietro.repository;

import com.gerenciamento.funcionarios.pietro.model.Funcionario;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

    List<Funcionario> findByDepartamentoId(UUID departamento_id);
    List<Funcionario> findByCargoId(UUID cargo_id);

}
