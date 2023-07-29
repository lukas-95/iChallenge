package com.example.ichallenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "tb_pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank(message = "Atributo de preenchimento obrigatório")
    @Size(min = 2, max = 30, message = "O atributo deve ter entre 2 e 30 caracteres")
    private String nome;

    @NotBlank(message = "Atributo de preenchimento obrigatório")
    @Size(min = 2, max = 30, message = "O atributo deve ter entre 2 e 30 caracteres")
    private String sobreNome;

    @NotNull(message = "Atributo de preenchimento obrigatório")
    @Max(value = 999,  message = "O atributo deve ter no máximo 3 digitos")
    @Min(value = 0,  message = "O atributo deve ter no mínimo 0 digitos")
    private Integer idade;


    @NotBlank(message = "Atributo de preenchimento obrigatário")
    @Size(min = 2, max = 30, message = "O atributo deve ter entre 2 e 30 caracteres")
    private String pais;

    public Pessoa(Long id, String nome, String sobreNome, @NotNull(message = "Atributo de preenchimento obrigatário") Integer idade, String pais) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
        this.pais = pais;
    }


    public Pessoa() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
