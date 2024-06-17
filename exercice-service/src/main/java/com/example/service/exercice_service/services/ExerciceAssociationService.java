package com.example.service.exercice_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.exercice_service.entity.ExerciceAssociation;
import com.example.service.exercice_service.repository.ExerciceAssociationRepository;

@Service
public class ExerciceAssociationService {
    @Autowired
    private ExerciceAssociationRepository exerciceAssociationRepository;

    public List<ExerciceAssociation> findAll() {
        return exerciceAssociationRepository.findAll();
    }

    public Optional<ExerciceAssociation> findById(Long id) {
        return exerciceAssociationRepository.findById(id);
    }

    public ExerciceAssociation save(ExerciceAssociation exerciceAssociation) {
        return exerciceAssociationRepository.save(exerciceAssociation);
    }

    public void deleteById(Long id) {
        exerciceAssociationRepository.deleteById(id);
    }
}
