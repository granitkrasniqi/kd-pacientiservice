package com.karteladentare.kdpacientiservice.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Diagnoza implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(columnDefinition = "text")
    private String shenime;
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "pacienti_id", nullable = false)
    private Pacienti pacienti;

    public Diagnoza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShenime() {
        return shenime;
    }

    public void setShenime(String shenime) {
        this.shenime = shenime;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Pacienti getPacienti() {
        return pacienti;
    }

    public void setPacienti(Pacienti pacienti) {
        this.pacienti = pacienti;
    }
}
