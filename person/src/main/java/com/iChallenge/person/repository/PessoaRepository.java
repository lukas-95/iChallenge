package com.iChallenge.person.repository;

import com.iChallenge.person.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Long> {


}
