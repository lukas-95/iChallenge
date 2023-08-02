package com.example.ichallenge.repository;

import com.example.ichallenge.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
