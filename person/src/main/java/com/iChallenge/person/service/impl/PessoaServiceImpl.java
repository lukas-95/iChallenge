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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada com o ID: " + id));
    }


    @Override
    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa savePessoa(Pessoa pessoa) {
        pessoaRepository.saveAndFlush(pessoa);
        log.info("Salvando pessoa {} com ID {}", pessoa.getNome(), pessoa.getId());
        NotifyCheckResponse notifyCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/notifyCheck/{personId}",
                NotifyCheckResponse.class,
                pessoa.getId()

        );

        assert notifyCheckResponse != null;
        if (notifyCheckResponse.isApproved().equals(true)){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pessoaRepository.save(pessoa)).getBody();

        }

        else {
            pessoaRepository.delete(pessoa);
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

    }


    @Override
    public void deletePessoa(Long id) {

        log.info("Deletando Pessoa com ID: {}", id);

        NotifyCheckResponse notifyCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/notifyCheck/{personId}",
                NotifyCheckResponse.class,
                id
        );

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);



        if (pessoa.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        assert notifyCheckResponse != null;
        if (!notifyCheckResponse.isApproved()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        pessoaRepository.deleteById(id);
    }
}