package com.iChallenge.person.service.impl;

import com.iChallenge.person.entity.Pessoa;
import com.iChallenge.person.repository.PessoaRepository;
import com.iChallenge.person.response.NotifyCheckResponse;
import com.iChallenge.person.service.PessoaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    private final RestTemplate restTemplate;


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
        log.info("Salvando pessoa {}", pessoa);
        pessoaRepository.saveAndFlush(pessoa);

        NotifyCheckResponse notifyCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/notifyCheck/{personId}",
                NotifyCheckResponse.class,
                pessoa.getId()

        );

        assert notifyCheckResponse != null;
        if (notifyCheckResponse.isApproved()){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pessoaRepository.save(pessoa)).getBody();
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
    }


    @Override
    public void deletePessoa(Long id) {
        log.info("Deletando pessoa {}", id);

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if (pessoa.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        pessoaRepository.deleteById(id);
    }
}