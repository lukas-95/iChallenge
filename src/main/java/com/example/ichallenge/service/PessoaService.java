package com.example.ichallenge.service;

import com.example.ichallenge.entity.Pessoa;

import java.util.List;

public interface PessoaService {
    Pessoa getPessoa(Long  id);

    List<Pessoa> getAllPessoas();

    Pessoa savePessoa(Pessoa pessoa);



    void deletePessoa(Long id);


}
