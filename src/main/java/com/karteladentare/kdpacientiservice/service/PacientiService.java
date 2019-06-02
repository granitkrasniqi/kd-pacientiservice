package com.karteladentare.kdpacientiservice.service;

import com.karteladentare.kdpacientiservice.domain.Pacienti;
import com.karteladentare.kdpacientiservice.exceptions.PacientiNotFoundException;

import java.util.List;

public interface PacientiService {
    List<Pacienti> ktheTeGjithPacientet();

    List<Pacienti> ktheTeGjithPacientetSipasAktiv(boolean aktiv);

    Pacienti shtoPacientin(Pacienti pacienti);

    Pacienti perditesoPacientin(Pacienti pacienti)
            throws PacientiNotFoundException;

    long numriTotalPacienteve();

    void fshijPacientin(Long pacientiId) throws PacientiNotFoundException;

    Pacienti kthePacientin(Long pacientiId) throws PacientiNotFoundException;
}
