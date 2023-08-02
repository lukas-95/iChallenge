package com.example.ichallenge.controller;

import com.example.ichallenge.dto.PessoaDTO;
import com.example.ichallenge.dto.PessoaPatchDTO;
import com.example.ichallenge.entity.Pessoa;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPessoaController {

    @GetMapping("/all")
    ResponseEntity<List<Pessoa>> getAll();

    @GetMapping("/{id}")
    ResponseEntity <Pessoa> getById(@PathVariable Long id);

    @PostMapping("/cadastrar")
    ResponseEntity <Pessoa> cadastrarPessoa(@Valid @RequestBody PessoaDTO pessoaDTO);

    @PatchMapping("/{id}")
    ResponseEntity<Pessoa> updatePessoaField(@PathVariable Long id, @RequestBody PessoaPatchDTO pessoaPatchDTO);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deletePessoa(@PathVariable Long id);



}
