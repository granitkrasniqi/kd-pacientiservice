package com.karteladentare.kdpacientiservice.integrationtests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karteladentare.kdpacientiservice.domain.Pacienti;
import com.karteladentare.kdpacientiservice.repository.PacientiRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PacientiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PacientiRepository pacientiRepository;

    @Test
    public void testAddPacienti() throws Exception {
        Pacienti pacienti = new Pacienti();
        pacienti.setNumriPersonal(993281L);
        pacienti.setEmri("Filan");
        pacienti.setMbiemri("Fistek");

        mockMvc.perform(post("/v1/pacientet")
                       .contentType(MediaType.APPLICATION_JSON_UTF8)
                       .content(objectMapper.writeValueAsString(pacienti)))
                    .andExpect(status().isCreated());

        doReturn(Optional.of(pacienti)).when(pacientiRepository).findByNumriPersonal(993281L);

        Optional<Pacienti> p = pacientiRepository
                                    .findByNumriPersonal(pacienti.getNumriPersonal());

        assertThat(p.get().getNumriPersonal()).isEqualTo(pacienti.getNumriPersonal());
    }

    @Test
    public void testUpdatePacienti() throws Exception {
        Pacienti pacienti = new Pacienti();
        pacienti.setId(1L);
        pacienti.setNumriPersonal(993281L);
        pacienti.setEmri("Filane");
        doReturn(Optional.of(pacienti)).when(pacientiRepository).findById(pacienti.getId());

        mockMvc.perform(put("/v1/pacientet/{pacientiId}", pacienti.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(pacienti)))
                .andExpect(status().isOk());

        doReturn(Optional.of(pacienti)).when(pacientiRepository).findByNumriPersonal(993281L);

        Optional<Pacienti> p = pacientiRepository
                .findByNumriPersonal(pacienti.getNumriPersonal());

        assertThat(p.get().getEmri()).isEqualTo(pacienti.getEmri());
    }

    @Test
    public void testDeletePacienti() throws Exception {
        Pacienti pacienti = new Pacienti();
        pacienti.setId(1L);
        pacienti.setNumriPersonal(993281L);
        doNothing().when(pacientiRepository).deleteById(any());
        doReturn(Optional.of(pacienti)).when(pacientiRepository).findById(pacienti.getId());
        doReturn(Optional.empty()).when(pacientiRepository).findByNumriPersonal(993281L);

        mockMvc.perform(delete("/v1/pacientet/{id}", pacienti.getId())
                        ).andExpect(status().isNoContent());

        Optional<Pacienti> p = pacientiRepository
                                    .findByNumriPersonal(pacienti.getNumriPersonal());

        assertThat(p.isPresent()).isEqualTo(false);
    }
}
