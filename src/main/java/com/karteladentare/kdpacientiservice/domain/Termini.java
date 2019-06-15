package com.karteladentare.kdpacientiservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

public class Termini {

    private Long id;
    private Long pacientiId;
    private String shenime;
    private LocalDate dataTerminit;
    private LocalTime kohaFillimit;
    private LocalTime kohaMbarimit;


    public Long getPacientiId() {
        return pacientiId;
    }

    public void setPacientiId(Long pacientiId) {
        this.pacientiId = pacientiId;
    }

    public String getShenime() {
        return shenime;
    }

    public void setShenime(String shenime) {
        this.shenime = shenime;
    }

    public LocalDate getDataTerminit() {
        return dataTerminit;
    }

    public void setDataTerminit(LocalDate dataTerminit) {
        this.dataTerminit = dataTerminit;
    }

    public LocalTime getKohaFillimit() {
        return kohaFillimit;
    }

    public void setKohaFillimit(LocalTime kohaFillimit) {
        this.kohaFillimit = kohaFillimit;
    }

    public LocalTime getKohaMbarimit() {
        return kohaMbarimit;
    }

    public void setKohaMbarimit(LocalTime kohaMbarimit) {
        this.kohaMbarimit = kohaMbarimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
