package com.karteladentare.kdpacientiservice.service;

import com.karteladentare.kdpacientiservice.domain.Pacienti;
import com.karteladentare.kdpacientiservice.exceptions.PacientiNotFoundException;
import com.karteladentare.kdpacientiservice.repository.PacientiRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PacientiServiceTest {

    /**
     * Service that we want to test
     */
    @Autowired
    private PacientiService pacientiService;

    /**
     * A mock version of the PacientiRepository for use in our tests.
     */
    @MockBean
    private PacientiRepository pacientiRepository;

    @Test
    @DisplayName("Test kthePacientin Success")
    public void testKthePacientinSuccess() throws PacientiNotFoundException {
        // Setup Mock
        Pacienti pacienti = new Pacienti();
        pacienti.setId(1L);
        doReturn(Optional.of(pacienti)).when(pacientiRepository).findById(1L);

        // Execute the service call
        Pacienti returnedPacienti = pacientiService.kthePacientin(1L);

        // Assert
        assertThat(returnedPacienti).isSameAs(pacienti);
    }

    @Test(expected = PacientiNotFoundException.class)
    @DisplayName("Test kthePacientin Not Found")
    public void testKthePacientinNotFound() throws PacientiNotFoundException {
        // Setup Mock
        Pacienti pacienti = new Pacienti();
        pacienti.setId(1L);
        doReturn(Optional.empty()).when(pacientiRepository).findById(1L);

        // Execute the service call
        Pacienti returnedPacienti = pacientiService.kthePacientin(1L);

    }

    @Test
    @DisplayName("Test ktheTeGjithPacientet Success")
    public void testKtheTeGjithPacientetSuccess() {
        // Setup Mock
        List<Pacienti> pacientsList = Arrays.asList(new Pacienti(), new Pacienti());
        doReturn(pacientsList).when(pacientiRepository).findAllAktiv();

        // Execute the service call
        List<Pacienti> returnedPacientsList = pacientiService.ktheTeGjithPacientet();

        // Assert
        assertThat(returnedPacientsList).isEqualTo(pacientsList);
    }

    @Test
    @DisplayName("Test ktheTeGjithPacientetSipasAktiv True Success")
    public void ktheTeGjithPacientetSipasAktivTrueSuccess() {
        // Setup Mock
        List<Pacienti> activePacientsList = new ArrayList<>();
        Pacienti p1 = new Pacienti();
        p1.setAktiv(true);
        Pacienti p2 = new Pacienti();
        p2.setAktiv(true);

        activePacientsList.add(p1);
        activePacientsList.add(p2);

        doReturn(activePacientsList).when(pacientiRepository.findAllByAktiv(true));

        //
    }
}
