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
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaPatchServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa updatePessoa(Long id, PessoaPatchDTO pessoaPatchDTO) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (optionalPessoa.isEmpty()) {
            return null;
        }

        Pessoa pessoa = optionalPessoa.get();

        if (pessoaPatchDTO.getNome() != null) {
            updateNome(pessoa, pessoaPatchDTO.getNome());
        }

        if (pessoaPatchDTO.getIdade() != null) {
            updateIdade(pessoa, pessoaPatchDTO.getIdade());
        }

        if (pessoaPatchDTO.getPais() != null) {
            updatePais(pessoa, pessoaPatchDTO.getPais());
        }

        pessoaRepository.save(pessoa);

        return pessoa;
    }

    private void updateNome(Pessoa pessoa, String nome) {
        if (nome.length() >= 2 && nome.length() <= 30) {
            pessoa.setNome(nome);
        } else {
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    private void updateIdade(Pessoa pessoa, Integer idade) {
        if (idade >= 0 && idade <= 999) {
            pessoa.setIdade(idade);
        } else {
            throw new IllegalArgumentException("Idade inválida");
        }
    }

    private void updatePais(Pessoa pessoa, String pais) {
        if (pais.length() >= 2 && pais.length() <= 30) {
            pessoa.setPais(pais);
        } else {
            throw new IllegalArgumentException("País inválido");
        }
    }

}
