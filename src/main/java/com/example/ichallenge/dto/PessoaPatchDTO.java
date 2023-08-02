package com.example.ichallenge.dto;

public class PessoaPatchDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private String pais;

    public PessoaPatchDTO() {
    }

    public PessoaPatchDTO(Long id, String nome, Integer idade, String pais) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.pais = pais;
    }

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
