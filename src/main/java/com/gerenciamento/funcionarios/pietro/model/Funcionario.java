package com.gerenciamento.funcionarios.pietro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column
    private String nome;

    @Column
    private int idade;

    @Column
    private double salario;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    public Funcionario(UUID id, String nome, int idade, double salario, Departamento departamento, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public Funcionario() {

    }
}
