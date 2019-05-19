package com.karteladentare.kdpacientiservice.service;

import com.karteladentare.kdpacientiservice.domain.Pacienti;
import com.karteladentare.kdpacientiservice.exceptions.PacientiNotFoundException;
import com.karteladentare.kdpacientiservice.repository.PacientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PacientiService {

    @Autowired
    private PacientiRepository pacientiRepository;

    public List<Pacienti> ktheTeGjithPacientet() {
        return pacientiRepository.findAll();
    }

    public Pacienti shtoPacientin(Pacienti pacienti) {
        // set today as the date of registration
        LocalDate today = LocalDate.now();
        pacienti.setDataRegjistrimit(today);

        // set aktiv attribute to true
        pacienti.setAktiv(true);

        // save patient
        return pacientiRepository.save(pacienti);
    }

    public Pacienti perditesoPacientin(Pacienti pacienti)
            throws PacientiNotFoundException {
        Optional<Pacienti> pacientiOptional = pacientiRepository.findById(pacienti.getId());
        if (pacientiOptional.isPresent()) {
            return pacientiRepository.save(pacienti);
        } else {
            throw new PacientiNotFoundException("Pacienti nuk egziston");
        }
    }

    public void fshijPacientin(Long pacientiId) {
        pacientiRepository.deleteById(pacientiId);
    }
}
