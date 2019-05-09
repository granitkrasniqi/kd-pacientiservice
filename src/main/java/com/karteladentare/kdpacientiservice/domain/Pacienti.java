package com.karteladentare.kdpacientiservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pacienti {
    @Id
    @GeneratedValue
    private Long id;
    private String emri;
    private String mbiemri;
    private char gjinia;

    public Pacienti() {
    }

    public Pacienti(String emri, String mbiemri, char gjinia) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.gjinia = gjinia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
