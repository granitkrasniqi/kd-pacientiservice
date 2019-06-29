package com.karteladentare.kdpacientiservice.service;

import com.karteladentare.kdpacientiservice.domain.Diagnoza;
import com.karteladentare.kdpacientiservice.exceptions.DiagnozaNotFoundException;

import java.util.List;

public interface DiagnozaService {

    /**
     * Kthen te gjitha diagnozat qe i takojne nje pacienti
     * @return Te gjitha diagnoat e nje pacienti ne database
     */
    List<Diagnoza> ktheTeGjithaDiagnozatPacientit(Long pacientiId);

    Diagnoza shtoDiagnozen(Diagnoza diagnoza);

    Diagnoza perditesoDiagnozen(Diagnoza diagnoza);

    void fshijPacientin(Long diagnozaId) throws DiagnozaNotFoundException;

    Diagnoza ktheDiagnozen(Long diagnozaId) throws DiagnozaNotFoundException;
}
