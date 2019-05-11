package com.karteladentare.kdpacientiservice.service;

import com.karteladentare.kdpacientiservice.domain.Pacienti;
import com.karteladentare.kdpacientiservice.repository.PacientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientiService {

    @Autowired
    private PacientiRepository pacientiRepository;

    public List<Pacienti> ktheTeGjithPacientet() {
        return pacientiRepository.findAll();
    }


}
