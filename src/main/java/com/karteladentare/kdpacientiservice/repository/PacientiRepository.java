package com.karteladentare.kdpacientiservice.repository;

import com.karteladentare.kdpacientiservice.domain.Pacienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacientiRepository extends JpaRepository<Pacienti, Long> {
    @Query("SELECT p FROM Pacienti p WHERE p.aktiv = true")
    List<Pacienti> findAllAktiv();
    List<Pacienti> findAllByAktiv(boolean aktiv);
    Optional<Pacienti> findByNumriPersonal(Long numriPersonal);
}
