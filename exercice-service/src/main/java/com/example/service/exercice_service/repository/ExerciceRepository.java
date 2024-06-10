package com.example.service.exercice_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service.exercice_service.entity.Exercice;

public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
    
}
