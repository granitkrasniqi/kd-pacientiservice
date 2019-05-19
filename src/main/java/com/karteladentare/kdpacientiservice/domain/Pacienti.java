package com.karteladentare.kdpacientiservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Pacienti {
    @Id
    @GeneratedValue
    private Long id;
    private Long numriPersonal;
    private String emri;
    private String mbiemri;
    private char gjinia;
    private String numriTelefonit;
    private String email;
    private LocalDate diteLindja;
    @Column(columnDefinition = "text")
    private String shenimeTjera;
    private String adresa;
    private LocalDate dataRegjistrimit;
    private boolean aktiv;

    public Pacienti() {
    }

    public Pacienti(Long numriPersonal, String emri, String mbiemri, char gjinia, String numriTelefonit,
                    String email, LocalDate diteLindja, String shenimeTjera, String adresa,
                    LocalDate dataRegjistrimit, boolean aktiv) {
        this.numriPersonal = numriPersonal;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.gjinia = gjinia;
        this.numriTelefonit = numriTelefonit;
        this.email = email;
        this.diteLindja = diteLindja;
        this.shenimeTjera = shenimeTjera;
        this.adresa = adresa;
        this.dataRegjistrimit = dataRegjistrimit;
        this.aktiv = aktiv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumriPersonal() {
        return numriPersonal;
    }

    public void setNumriPersonal(Long numriPersonal) {
        this.numriPersonal = numriPersonal;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public char getGjinia() {
        return gjinia;
    }

    public void setGjinia(char gjinia) {
        this.gjinia = gjinia;
    }

    public String getNumriTelefonit() {
        return numriTelefonit;
    }

    public void setNumriTelefonit(String numriTelefonit) {
        this.numriTelefonit = numriTelefonit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDiteLindja() {
        return diteLindja;
    }

    public void setDiteLindja(LocalDate diteLindja) {
        this.diteLindja = diteLindja;
    }

    public String getShenimeTjera() {
        return shenimeTjera;
    }

    public void setShenimeTjera(String shenimeTjera) {
        this.shenimeTjera = shenimeTjera;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public LocalDate getDataRegjistrimit() {
        return dataRegjistrimit;
    }

    public void setDataRegjistrimit(LocalDate dataRegjistrimit) {
        this.dataRegjistrimit = dataRegjistrimit;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }
}
