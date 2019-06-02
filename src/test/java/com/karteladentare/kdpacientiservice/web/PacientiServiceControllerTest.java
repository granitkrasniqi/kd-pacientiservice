package com.karteladentare.kdpacientiservice.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karteladentare.kdpacientiservice.domain.Pacienti;
import com.karteladentare.kdpacientiservice.exceptions.PacientiNotFoundException;
import com.karteladentare.kdpacientiservice.service.PacientiService;
import com.karteladentare.kdpacientiservice.service.PacientiServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PacientiServiceControllerTest {

    @MockBean
    private PacientiService pacientiService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /v1/pacientet - Success (Return all resources)")
    public void testKthePacientetGetSuccess() throws Exception {
        // setup mock
        when(pacientiService.ktheTeGjithPacientet()).thenReturn(Arrays.asList(new Pacienti(), new Pacienti()));
        mockMvc.perform(get("/v1/pacientet")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @DisplayName("GET /v1/pacientet/1 - Success (Return single resource by id)")
    public void testKthePacientin() throws Exception {
        // setup mock
        Pacienti p = new Pacienti();
        p.setId(1L);

        when(pacientiService.kthePacientin(1L)).thenReturn(p);


        // Perform request
        mockMvc.perform(get("/v1/pacientet/{pacientiId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", equalTo(1)));
    }

    @Test
    @DisplayName("GET /v1/pacientet/1 - Not Found (Return single resource by id)")
    public void testKthePacientinNotFound() throws Exception {
        // Setup mock
        when(pacientiService.kthePacientin(1L)).thenThrow(PacientiNotFoundException.class);

        // Perform request
        mockMvc.perform(get("/v1/pacientet/{pacientiId}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /v1/pacientet - Success (Return 201 - Resource Created Successfully)")
    public void shtoPacientinTest() throws Exception {
        // Setup mock
        Pacienti p = new Pacienti();
        p.setEmri("Filan");
        p.setMbiemri("Fistek");
        p.setId(1L);

        when(pacientiService.shtoPacientin(p)).thenReturn(p);

        // Perform request
        mockMvc.perform(post("/v1/pacientet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(p)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("PUT /v1/pacientet/1 - Success (Return 200)")
    public void testPerditesoPacientin() throws Exception {
        // Setup mock
        Pacienti p = new Pacienti();
        p.setEmri("Filan");
        p.setMbiemri("Fistek");
        p.setId(1L);


        when(pacientiService.perditesoPacientin(p)).thenReturn(p);

        // Perform request
        mockMvc.perform(put("/v1/pacientet/{pacientiId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(p)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("PUT /v1/pacientet/1 - Not Found (Return 404)")
    public void testPerditesoPacientinNotFound() throws Exception {
        // Setup mock
        Pacienti p = new Pacienti();
        p.setEmri("Filan");
        p.setMbiemri("Fistek");
        p.setId(1L);

        Pacienti p2 = new Pacienti();
        p2.setId(4123123L);


        when(pacientiService.perditesoPacientin(p2)).thenThrow(PacientiNotFoundException.class);

        // Perform request
        mockMvc.perform(put("/v1/pacientet/{pacientiId}", 4123123)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(p2)))
                .andExpect(status().isNotFound());
    }




    @Test
    @DisplayName("DELETE /v1/pacientet/1 - Success")
    public void testPacientiDeleteSuccess() throws Exception {
//        pacientiService = mock(PacientiServiceImpl.class);

        Pacienti mockPacienti = new Pacienti();
        mockPacienti.setId(1L);

        // Setup the mocked service
//        doReturn(mockPacienti).when(pacientiService).kthePacientin(1L);
//        when(pacientiService.kthePacientin(1L)).thenReturn(mockPacienti);
        doNothing().when(pacientiService).fshijPacientin(1L);


        mockMvc.perform(delete("/v1/pacientet/{id}", 1))
                        .andExpect(status().isNoContent());

    }
}
