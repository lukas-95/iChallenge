package com.example.ichallenge.controller;

import com.example.ichallenge.dto.PessoaDTO;
import com.example.ichallenge.dto.PessoaPatchDTO;
import com.example.ichallenge.entity.Pessoa;
import com.example.ichallenge.service.PessoaPatchService;
import com.example.ichallenge.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController implements IPessoaController{

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaPatchService pessoaPatchService;


    public ResponseEntity<List<Pessoa>> getAll() {
        return ResponseEntity.ok(pessoaService.getAllPessoas());
    }


    public ResponseEntity <Pessoa> getById(Long id) {

        return ResponseEntity.ok(pessoaService.getPessoa(id));
    }


    public ResponseEntity <Pessoa> cadastrarPessoa(PessoaDTO pessoaDTO) {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setSobreNome(pessoaDTO.getSobreNome());
        pessoa.setIdade(pessoaDTO.getIdade());
        pessoa.setPais(pessoaDTO.getPais());

        Pessoa pessoaCadastrada = pessoaService.savePessoa(pessoa);
        return ResponseEntity.ok(pessoaCadastrada);
    }

    public ResponseEntity<Pessoa> updatePessoaField(@PathVariable Long id, @RequestBody PessoaPatchDTO pessoaPatchDTO) {
        Pessoa pessoaAtualizada = pessoaPatchService.updatePessoa(id, pessoaPatchDTO);
        if (pessoaAtualizada != null) {
            return ResponseEntity.ok(pessoaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
    }


}
