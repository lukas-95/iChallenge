package com.example.ichallenge.service.impl;

import com.example.ichallenge.entity.Pessoa;
import com.example.ichallenge.repository.PessoaRepository;
import com.example.ichallenge.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService
{
    @Autowired
    private PessoaRepository pessoaRepository;


    @Override
    public Pessoa getPessoa(Long id) {
        return pessoaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @Override
    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa savePessoa(Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pessoaRepository.save(pessoa)).getBody();
    }


    @Override
    public void deletePessoa(Long id) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if (pessoa.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        pessoaRepository.deleteById(id);

    }
}
