package com.karteladentare.kdpacientiservice.service;

import com.karteladentare.kdpacientiservice.domain.Diagnoza;
import com.karteladentare.kdpacientiservice.exceptions.DiagnozaNotFoundException;
import com.karteladentare.kdpacientiservice.repository.DiagnozaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiagnozaServiceImpl implements DiagnozaService {

    private DiagnozaRepository diagnozaRepository;

    @Autowired
    public DiagnozaServiceImpl(DiagnozaRepository diagnozaRepository) {
        this.diagnozaRepository = diagnozaRepository;
    }

    @Override
    public List<Diagnoza> ktheTeGjithaDiagnozatPacientit(Long pacientiId) {
        return diagnozaRepository.findAllByPacientiId(pacientiId);
    }

    @Override
    public Diagnoza shtoDiagnozen(Diagnoza diagnoza) {
        diagnoza.setData(LocalDate.now());
        return diagnozaRepository.save(diagnoza);
    }

    @Override
    public Diagnoza perditesoDiagnozen(Diagnoza diagnoza) {
        return null;
    }

    @Override
    public void fshijPacientin(Long diagnozaId) throws DiagnozaNotFoundException {

    }

    @Override
    public Diagnoza ktheDiagnozen(Long diagnozaId) throws DiagnozaNotFoundException {
        return null;
    }
}
