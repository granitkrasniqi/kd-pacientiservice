package com.karteladentare.kdpacientiservice.repository;

import com.karteladentare.kdpacientiservice.domain.Diagnoza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnozaRepository extends JpaRepository<Diagnoza, Long> {
    List<Diagnoza> findAllByPacientiId(Long pacientiId);
}
