package com.iChallenge.person.service;

import com.iChallenge.person.entity.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa getPessoa(Long  id);

    List<Pessoa> getAllPessoas();

    Pessoa savePessoa(Pessoa pessoa);



    void deletePessoa(Long id);


}
