package com.example.service.eleve_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service.eleve_service.entity.Eleve;

public interface EleveRepository extends JpaRepository<Eleve, Long>  {
    Optional<Eleve> findByEmail(String email);
}
