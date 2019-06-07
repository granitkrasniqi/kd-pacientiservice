package com.karteladentare.kdpacientiservice.web;

import com.karteladentare.kdpacientiservice.domain.Pacienti;
import com.karteladentare.kdpacientiservice.exceptions.PacientiExistsException;
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

    @GetMapping("/statusi")
    public Iterable<Pacienti> kthePacientetSipasAktiv(@RequestParam(value = "aktiv", defaultValue = "true") Boolean aktiv) {
        return pacientiService.ktheTeGjithPacientetSipasAktiv(aktiv);
    }

    @GetMapping("/{pacientiId}")
    public Pacienti kthePacientin(@PathVariable("pacientiId") Long pacientiId) {
        try {
            return pacientiService.kthePacientin(pacientiId);
        } catch (PacientiNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pacienti shtoPacientin(@RequestBody Pacienti pacienti) {
        try {
            return pacientiService.shtoPacientin(pacienti);
        } catch (PacientiExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage()
            );
        }
    }

    @PutMapping("/{pacientiId}")
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
        try {
            pacientiService.fshijPacientin(pacientiId);
        } catch (PacientiNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/numriPacienteve")
    public long numriTotalPacienteve() {
        return pacientiService.numriTotalPacienteve();
    }



}
