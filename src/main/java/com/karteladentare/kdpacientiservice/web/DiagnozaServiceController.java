package com.karteladentare.kdpacientiservice.web;

import com.karteladentare.kdpacientiservice.domain.Diagnoza;
import com.karteladentare.kdpacientiservice.exceptions.PacientiNotFoundException;
import com.karteladentare.kdpacientiservice.service.DiagnozaService;
import com.karteladentare.kdpacientiservice.service.DiagnozaServiceImpl;
import com.karteladentare.kdpacientiservice.service.PacientiService;
import com.karteladentare.kdpacientiservice.service.PacientiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/v1/diagnozat", produces = "application/json")
public class DiagnozaServiceController {

    private DiagnozaService diagnozaService;
    private PacientiService pacientiService;

    @Autowired
    public DiagnozaServiceController(DiagnozaServiceImpl diagnozaServiceImpl, PacientiServiceImpl pacientiServiceImpl) {
        this.diagnozaService = diagnozaServiceImpl;
        this.pacientiService = pacientiServiceImpl;
    }

    @GetMapping("/pacienti/{id}")
    public Iterable<Diagnoza> diagnozatPacientit(@PathVariable("id") Long id) {
        return diagnozaService.ktheTeGjithaDiagnozatPacientit(id);
    }

    @PostMapping("/pacienti/{pacientiId}")
    public Diagnoza shtoDiagnozenPacientit(@PathVariable("pacientiId") Long pacientiId,
                                           @RequestBody Diagnoza diagnoza) {
        try {
            diagnoza.setPacienti(pacientiService.kthePacientin(pacientiId));

            return diagnozaService.shtoDiagnozen(diagnoza);
        } catch (PacientiNotFoundException e) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
