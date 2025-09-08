package com.rhenan.tarefas_api_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
// Tarefa no sistema de gerenciamento 
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataEntrega;

    private String responsavel;

    // Getters separados do Setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public String getResponsavel() {
        return responsavel;
    }

    // Setters separado do Getters

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    // toString para facilitar testes e logs
    @Override
    public String toString() {
        return "Tarefa {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}
