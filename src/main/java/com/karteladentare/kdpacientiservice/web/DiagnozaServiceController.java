package com.karteladentare.kdpacientiservice.web;

import com.karteladentare.kdpacientiservice.domain.Diagnoza;
import com.karteladentare.kdpacientiservice.service.DiagnozaService;
import com.karteladentare.kdpacientiservice.service.DiagnozaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/v1/diagnozat", produces = "application/json")
public class DiagnozaServiceController {

    private DiagnozaService diagnozaService;

    @Autowired
    public DiagnozaServiceController(DiagnozaServiceImpl diagnozaServiceImpl) {
        this.diagnozaService = diagnozaServiceImpl;
    }

    @GetMapping("/pacienti/{id}")
    public Iterable<Diagnoza> diagnozatPacientit(@PathVariable("id") Long id) {
        return diagnozaService.ktheTeGjithaDiagnozatPacientit(id);
    }

}
