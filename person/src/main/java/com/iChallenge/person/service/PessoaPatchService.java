package com.iChallenge.person.service;

import com.iChallenge.person.dto.PessoaPatchDTO;
import com.iChallenge.person.entity.Pessoa;

public interface PessoaPatchService {

    Pessoa updatePessoa(Long id, PessoaPatchDTO pessoaPatchDTO);

}
