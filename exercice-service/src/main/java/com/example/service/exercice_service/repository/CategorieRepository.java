package com.example.service.exercice_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.service.exercice_service.entity.Categorie;

public interface  CategorieRepository extends JpaRepository<Categorie, Long> {
    Optional<Categorie> findByNomCategorie(String nomCategorie);
}
