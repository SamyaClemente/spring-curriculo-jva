package com.larissa.curriculo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "curriculos")
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String objetivo;
    private String experienciaProfissional;
    private String educacao;
    private String habilidades;

    public Curriculo() {
    }

    public Curriculo(String nome, String email, String telefone, String endereco, String objetivo, String experienciaProfissional, String educacao, String habilidades) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.objetivo = objetivo;
        this.experienciaProfissional = experienciaProfissional;
        this.educacao = educacao;
        this.habilidades = habilidades;
    }
}
