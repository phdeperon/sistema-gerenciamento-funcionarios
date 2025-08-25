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
public class Cargo {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column
    private String nomeCargo;

    @Column
    private String descricao;

    public Cargo(UUID id, String nomeCargo, String descricao) {
        this.id = id;
        this.nomeCargo = nomeCargo;
        this.descricao = descricao;
    }

    public Cargo() {
    }
}
