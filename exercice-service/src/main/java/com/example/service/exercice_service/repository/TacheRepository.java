package com.example.service.exercice_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service.exercice_service.entity.Tache;

public interface TacheRepository extends JpaRepository<Tache, Long> {

}
