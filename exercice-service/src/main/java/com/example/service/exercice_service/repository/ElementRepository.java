package com.example.service.exercice_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.service.exercice_service.entity.Element;

public interface ElementRepository extends JpaRepository<Element, Long> {
    Optional<Element> findByNomElement(String nomElement);
}
