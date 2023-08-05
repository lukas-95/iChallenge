package com.iChallenge.person.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iChallenge.person.dto.PessoaDTO;
import com.iChallenge.person.dto.PessoaPatchDTO;
import com.iChallenge.person.entity.Pessoa;
import com.iChallenge.person.service.PessoaPatchService;
import com.iChallenge.person.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaService pessoaService;

    @MockBean
    private PessoaPatchService pessoaPatchService;

    @Test
    public void testGetAllPessoas() throws Exception {
        // Mockando o serviço para retornar uma lista vazia de pessoas
        given(pessoaService.getAllPessoas()).willReturn(new ArrayList<>());

        // Executando a requisição GET /pessoas
        mockMvc.perform(MockMvcRequestBuilders.get("/pessoas/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    public void testGetPessoaById() throws Exception {
        Long pessoaId = 1L;
        Pessoa pessoa = new Pessoa(pessoaId, "Lucas", "Reck", 27, "Brasil");

        when(pessoaService.getPessoa(pessoaId)).thenReturn(pessoa);

        mockMvc.perform(MockMvcRequestBuilders.get("/pessoas/{id}", pessoaId))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(pessoaId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(pessoa.getNome()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sobreNome").value(pessoa.getSobreNome()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idade").value(pessoa.getIdade()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pais").value(pessoa.getPais()));
    }

    @Test
    public void testCadastrarPessoa() throws Exception {
        // Dados de entrada para a pessoa a ser cadastrada
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Lucas");
        pessoaDTO.setSobreNome("Reck");
        pessoaDTO.setIdade(27);
        pessoaDTO.setPais("Brasil");

        // Simulando que o serviço irá retornar a pessoa cadastrada
        Pessoa pessoaCadastrada = new Pessoa();
        pessoaCadastrada.setId(1L);
        pessoaCadastrada.setNome(pessoaDTO.getNome());
        pessoaCadastrada.setSobreNome(pessoaDTO.getSobreNome());
        pessoaCadastrada.setIdade(pessoaDTO.getIdade());
        pessoaCadastrada.setPais(pessoaDTO.getPais());
        when(pessoaService.savePessoa(Mockito.any(Pessoa.class))).thenReturn(pessoaCadastrada);

        // Executando a requisição POST /pessoas/cadastrar com os dados da pessoa
        mockMvc.perform(MockMvcRequestBuilders.post("/pessoas/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pessoaDTO)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(pessoaDTO.getNome()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sobreNome").value(pessoaDTO.getSobreNome()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idade").value(pessoaDTO.getIdade()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pais").value(pessoaDTO.getPais()));

        // Verificando se o serviço foi chamado com a pessoa correta
        ArgumentCaptor<Pessoa> pessoaCaptor = ArgumentCaptor.forClass(Pessoa.class);
        verify(pessoaService).savePessoa(pessoaCaptor.capture());
        Pessoa pessoaCadastradaArgument = pessoaCaptor.getValue();
        assertEquals(pessoaDTO.getNome(), pessoaCadastradaArgument.getNome());
        assertEquals(pessoaDTO.getSobreNome(), pessoaCadastradaArgument.getSobreNome());
        assertEquals(pessoaDTO.getIdade(), pessoaCadastradaArgument.getIdade());
        assertEquals(pessoaDTO.getPais(), pessoaCadastradaArgument.getPais());
    }


    @Test
    public void testUpdatePessoaField() throws Exception {
        Long pessoaId = 1L;
        PessoaPatchDTO pessoaPatchDTO = new PessoaPatchDTO();
        pessoaPatchDTO.setNome("Lucas");


        // Simulando que o serviço irá retornar a pessoa atualizada
        Pessoa pessoaAtualizada = new Pessoa();
        pessoaAtualizada.setId(pessoaId);
        pessoaAtualizada.setNome(pessoaPatchDTO.getNome());
        when(pessoaPatchService.updatePessoa(pessoaId, pessoaPatchDTO)).thenReturn(pessoaAtualizada);

        // Executando a requisição PATCH /pessoas/{id} com os dados da pessoa a serem atualizados
        mockMvc.perform(MockMvcRequestBuilders.patch("/pessoas/{id}", pessoaId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pessoaPatchDTO)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(pessoaId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(pessoaPatchDTO.getNome()));

        // Verificando se o serviço foi chamado com os parâmetros corretos
        ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<PessoaPatchDTO> pessoaPatchCaptor = ArgumentCaptor.forClass(PessoaPatchDTO.class);
        verify(pessoaPatchService).updatePessoa(idCaptor.capture(), pessoaPatchCaptor.capture());
        assertEquals(pessoaId, idCaptor.getValue());
        assertEquals(pessoaPatchDTO.getNome(), pessoaPatchCaptor.getValue().getNome());
    }


    // Método auxiliar para converter objeto em JSON
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDeletePessoa() throws Exception {
        Long pessoaId = 1L;

        // Simulando que a pessoa a ser deletada existe no sistema
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaId);
        pessoa.setNome("Lucas");
        pessoa.setSobreNome("Reck");
        when(pessoaService.getPessoa(pessoaId)).thenReturn(pessoa);

        // Executando a requisição DELETE /pessoas/{id}
        mockMvc.perform(MockMvcRequestBuilders.delete("/pessoas/{id}", pessoaId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        // Verificando se o serviço foi chamado com o parâmetro correto
        ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);
        verify(pessoaService).deletePessoa(idCaptor.capture());
        assertEquals(pessoaId, idCaptor.getValue());
    }





}
