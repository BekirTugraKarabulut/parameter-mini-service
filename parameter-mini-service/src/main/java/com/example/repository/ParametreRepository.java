package com.example.repository;

import com.example.model.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre,Long> {

    Parametre findByCode(Long code);

}
