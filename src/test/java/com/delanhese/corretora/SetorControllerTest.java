package com.delanhese.corretora;

import com.delanhese.corretora.controller.SetorController;
import com.delanhese.corretora.model.Setor;
import com.delanhese.corretora.repository.SetorRepository;
import com.delanhese.corretora.service.SetorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.filters.CorsFilter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * SetorControllerTest
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SetorController.class)
public class SetorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
    private SetorServiceImpl setorService;	

    @InjectMocks
    private SetorController setorController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(setorController)
                .addFilters(new CorsFilter())
                .build();
    }      
    
    @Test
    public void testGETAllSuccess() throws Exception {
        List<Setor> setores = Arrays.asList(new Setor(1L, "Híbrido"), new Setor(2L, "Papel"));
        
        ResponseEntity<List<Setor>> listaSetoresEsperado = new ResponseEntity(setores, HttpStatus.OK);        
        
        when(setorService.findAll()).thenReturn(listaSetoresEsperado);
        mockMvc.perform(get("/setor"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idSetor", is(listaSetoresEsperado.getBody().get(0).getIdSetor().intValue())))
                .andExpect(jsonPath("$[0].nome", is(listaSetoresEsperado.getBody().get(0).getNome())))
                .andExpect(jsonPath("$[1].idSetor", is(listaSetoresEsperado.getBody().get(1).getIdSetor().intValue())))
                .andExpect(jsonPath("$[1].nome", is(listaSetoresEsperado.getBody().get(1).getNome())));
        verify(setorService, times(1)).findAll();
        verifyNoMoreInteractions(setorService);
    }
    
    @Test
    public void testGETByIdSuccess() throws Exception {
        Setor setor = new Setor(1L, "Híbrido");

        ResponseEntity<Setor> setorEsperado = new ResponseEntity(setor, HttpStatus.OK);
        
        when(setorService.findById(1L)).thenReturn(setorEsperado);       
        
        mockMvc.perform(get("/setor/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idSetor", is(setorEsperado.getBody().getIdSetor().intValue())))
                .andExpect(jsonPath("$.nome", is(setorEsperado.getBody().getNome())));

        verify(setorService, times(1)).findById(1L);
        verifyNoMoreInteractions(setorService);
    }
    
    @Test
    public void testPOSTSetorSuccess() throws Exception {
        Setor setor = new Setor(null, "Tijolo");

        when(setorService.exists(setor)).thenReturn(false);
        doReturn(false).when(setorService).save(setor);

        mockMvc.perform(
                post("/setor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(setor)))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("http://localhost:8080/setor/")));

        verify(setorService, times(1)).exists(setor);
        verify(setorService, times(1)).save(setor);
        verifyNoMoreInteractions(setorService);
    }
    
    @Test
    public void testPUTSetorSuccess() throws Exception {
    	Setor setor = new Setor(1L, "Híbrido Alterado");
    	
    	ResponseEntity<Setor> reSetor = new ResponseEntity(setor, HttpStatus.OK);
    	
        //when(setorService.findById(setor.getIdSetor())).thenReturn(reSetor);
        when(setorService.update(setor.getIdSetor(), setor)).thenReturn(reSetor);

        mockMvc.perform(
                put("/setor/{id}", setor.getIdSetor())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reSetor)))
                .andExpect(status().isOk());

        verify(setorService, times(1)).findById(setor.getIdSetor());
        verify(setorService, times(1)).update(setor.getIdSetor(), setor);
        verifyNoMoreInteractions(setorService);
    }
    
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}