package com.gerenciamento.funcionarios.pietro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Departamento {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column
    private String nome_depto;

    public Departamento(UUID id, String nome_depto) {
        this.id = id;
        this.nome_depto = nome_depto;
    }

    public Departamento() {
    }
}
