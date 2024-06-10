package com.example.service.exercice_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service.exercice_service.entity.Ressource;

public interface RessourceRepository  extends JpaRepository<Ressource, Long> {
    Optional<Ressource> findByNomRessource(String nomRessource);
}
