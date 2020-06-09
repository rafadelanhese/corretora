package com.delanhese.corretora;

import com.delanhese.corretora.controller.SetorController;
import com.delanhese.corretora.service.SetorService;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * SetorControllerTest
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SetorController.class)
public class SetorControllerTest {

   /* private final String BASE_URL = "/setor";
    private final String CAMPO_REQUISITADO = "$.idSetor";
    private final String CAMPO_ID_SETOR = "/{id}";
    private final int ID_SETOR = 1;
    private final int VALOR_ESPERADO = 1;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SetorController restController;

    @MockBean
    private SetorService mockService;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
    }

    @Test
    public void testGETFindAllSetores() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL).accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGETSetorFindById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + CAMPO_ID_SETOR, ID_SETOR).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath(CAMPO_REQUISITADO).value(VALOR_ESPERADO));
    }

    @Test 
     public void testPOSTSetorCreate() throws Exception {
       
        when(mockService.save(any(Setor.class))).thenReturn(value)

       this.mockMvc.perform(post(BASE_URL)
       .contentType(MediaType.APPLICATION_JSON)
       .content("{" +  "nome"+ ":" + "Teste" + "}")
       .andExpect(status().isOk())
       .andExpect(jsonPath("$.idSetor").value("12345")) 
       .andExpect(jsonPath("$.nome").value("Teste"))
       .andDo(print());    
      }

    @Test
    public void testDELETESetor() throws Exception {
        // TESTA SE O RETORNO É STATUS 200
        this.mockMvc.perform(MockMvcRequestBuilders.delete(BASE_URL + CAMPO_ID_SETOR, ID_SETOR)).andExpect(status().isOk());
    }*/

}