package com.karteladentare.kdpacientiservice.web;

import com.karteladentare.kdpacientiservice.domain.Pacienti;
import com.karteladentare.kdpacientiservice.exceptions.PacientiNotFoundException;
import com.karteladentare.kdpacientiservice.service.PacientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping(path = "/v1/pacientet", produces = "application/json")
public class PacientiServiceController {

    @Autowired
    private PacientiService pacientiService;

    @GetMapping
    public Iterable<Pacienti> kthePacientet() {
        return pacientiService.ktheTeGjithPacientet();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pacienti shtoPacientin(@RequestBody Pacienti pacienti) {
        return pacientiService.shtoPacientin(pacienti);
    }

    @PutMapping(path = "/{pacientiId}")
    public Pacienti perditesoPacientin(@PathVariable("pacientiId") Long pacientiId,
                                       @RequestBody Pacienti pacienti) {
        try {
            pacienti.setId(pacientiId);
            return pacientiService.perditesoPacientin(pacienti);
        } catch (PacientiNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{pacientiId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void fshijPacientin(@PathVariable("pacientiId") Long pacientiId) {
        pacientiService.fshijPacientin(pacientiId);
    }



}
