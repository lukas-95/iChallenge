package com.iChallenge.person.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Atributo de preenchimento obrigatório")
    @Size(min = 2, max = 30, message = "O atributo deve ter entre 2 e 30 caracteres")
    private String nome;

    @NotBlank(message = "Atributo de preenchimento obrigatório")
    @Size(min = 2, max = 30, message = "O atributo deve ter entre 2 e 30 caracteres")
    private String sobreNome;

    @NotNull(message = "Atributo de preenchimento obrigatório")
    @Max(value = 999, message = "O atributo deve ter no máximo 3 digitos")
    @Min(value = 0, message = "O atributo deve ter no mínimo 0 digitos")
    private Integer idade;


    @NotBlank(message = "Atributo de preenchimento obrigatário")
    @Size(min = 2, max = 30, message = "O atributo deve ter entre 2 e 30 caracteres")
    private String pais;

}