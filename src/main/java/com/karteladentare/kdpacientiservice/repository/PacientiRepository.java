package com.karteladentare.kdpacientiservice.repository;

import com.karteladentare.kdpacientiservice.domain.Pacienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientiRepository extends JpaRepository<Pacienti, Long> {
}
