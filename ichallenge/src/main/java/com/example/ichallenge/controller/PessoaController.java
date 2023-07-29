package com.example.ichallenge.controller;

import com.example.ichallenge.model.Pessoa;
import com.example.ichallenge.service.PessoaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PessoaController.class);


    @GetMapping("/all")
    public ResponseEntity <List<Pessoa>> getAll() {
        return ResponseEntity.ok(pessoaService.getAllPessoas());
    }


    @GetMapping("/{id}")
    public ResponseEntity <Pessoa> getById( @PathVariable Long id) {

        return ResponseEntity.ok(pessoaService.getPessoa(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity <Pessoa> cadastrarPessoa(@Valid @RequestBody Pessoa pessoa) {

        return ResponseEntity.ok(pessoaService.savePessoa(pessoa));
    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Pessoa> updatePessoaField(
//            @PathVariable Long id,
//            @RequestBody Map<String, Object> updates) {
//
//        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
//        if (optionalPessoa.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Pessoa pessoa = optionalPessoa.get();
//
//        // Update only the specified fields in the updates map
//        if (updates.containsKey("nome")) {
//            String nome = (String) updates.get("nome");
//            if (nome != null && nome.length() >= 2 && nome.length() <= 30) {
//                pessoa.setNome(nome);
//            } else {
//                return ResponseEntity.badRequest().build();
//            }
//        }
//        if (updates.containsKey("sobreNome")) {
//            String sobreNome = (String) updates.get("sobreNome");
//            if (sobreNome != null && sobreNome.length() >= 2 && sobreNome.length() <= 30) {
//                pessoa.setSobreNome(sobreNome);
//            } else {
//                return ResponseEntity.badRequest().build();
//            }
//        }
//        if (updates.containsKey("idade")) {
//            Integer idade = (Integer) updates.get("idade");
//            if (idade != null && idade >= 0 && idade <= 999) {
//                pessoa.setIdade(idade);
//            } else {
//                return ResponseEntity.badRequest().build();
//            }
//        }
//        if (updates.containsKey("pais")) {
//            String pais = (String) updates.get("pais");
//            if (pais != null && pais.length() >= 2 && pais.length() <= 30) {
//                pessoa.setPais(pais);
//            } else {
//                return ResponseEntity.badRequest().build();
//            }
//        }
//
//        return ResponseEntity.ok(pessoa);
//    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deletePessoa(@PathVariable Long id) {

        pessoaService.deletePessoa(id);
    }


}
