package com.example.ichallenge.dto;

public class PessoaDTO {

    private Long id;
    private String nome;
    private String sobreNome;
    private Integer idade;
    private String pais;

    public PessoaDTO() {
    }

    public PessoaDTO(Long id, String nome, String sobreNome, Integer idade, String pais) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
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
