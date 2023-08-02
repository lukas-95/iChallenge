package com.example.ichallenge.service.impl;

import com.example.ichallenge.dto.PessoaPatchDTO;
import com.example.ichallenge.entity.Pessoa;
import com.example.ichallenge.repository.PessoaRepository;
import com.example.ichallenge.service.PessoaPatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PessoaPatchServiceImpl implements PessoaPatchService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa updatePessoa(Long id, PessoaPatchDTO pessoaPatchDTO) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (optionalPessoa.isEmpty()) {
            return null;
        }

        Pessoa pessoa = optionalPessoa.get();

        if (pessoaPatchDTO.getNome() != null && pessoaPatchDTO.getNome().length() >= 2 && pessoaPatchDTO.getNome().length() <= 30) {
            pessoa.setNome(pessoaPatchDTO.getNome());
        }

        if (pessoaPatchDTO.getIdade() != null && pessoaPatchDTO.getIdade() >= 0 && pessoaPatchDTO.getIdade() <= 999) {
            pessoa.setIdade(pessoaPatchDTO.getIdade());
        }

        if (pessoaPatchDTO.getPais() != null && pessoaPatchDTO.getPais().length() >= 2 && pessoaPatchDTO.getPais().length() <= 30) {
            pessoa.setPais(pessoaPatchDTO.getPais());
        }

        pessoaRepository.save(pessoa);

        return pessoa;
    }

}
