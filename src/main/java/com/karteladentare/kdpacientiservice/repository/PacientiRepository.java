package com.karteladentare.kdpacientiservice.repository;

import com.karteladentare.kdpacientiservice.domain.Pacienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacientiRepository extends JpaRepository<Pacienti, Long> {
    @Query("SELECT p FROM Pacienti p WHERE p.aktiv = true")
    public List<Pacienti> findAllAktiv();
    public List<Pacienti> findAllByAktiv(boolean aktiv);
}
