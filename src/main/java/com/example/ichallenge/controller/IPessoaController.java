package com.example.ichallenge.controller;

import com.example.ichallenge.model.Pessoa;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IPessoaController {

    @GetMapping("/all")
     ResponseEntity<List<Pessoa>> getAll();

    @GetMapping("/{id}")
     ResponseEntity <Pessoa> getById(@PathVariable Long id);

    @PostMapping("/cadastrar")
     ResponseEntity <Pessoa> cadastrarPessoa(@Valid @RequestBody Pessoa pessoa);





}
