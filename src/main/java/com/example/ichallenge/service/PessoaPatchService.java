package com.example.ichallenge.service;

import com.example.ichallenge.dto.PessoaPatchDTO;
import com.example.ichallenge.entity.Pessoa;

public interface PessoaPatchService {

    Pessoa updatePessoa(Long id, PessoaPatchDTO pessoaPatchDTO);

}
