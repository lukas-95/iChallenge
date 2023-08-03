package com.iChallenge.person.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaPatchDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private String pais;
}
