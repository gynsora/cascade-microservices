package com.example.service.exercice_service.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.exercice_service.entity.ExerciceAssociation;
import com.example.service.exercice_service.services.ExerciceAssociationService;

@RestController
@RequestMapping("/exercice-associations")
public class ExerciceAssociationController {
    @Autowired
    private ExerciceAssociationService exerciceAssociationService;

    @GetMapping
    public List<ExerciceAssociation> getAllExerciceAssociations() {
        return exerciceAssociationService.findAll();
    }
    
    // @GetMapping("/{id}")
    // public ResponseEntity<ExerciceAssociation> getExerciceAssociationById(@PathVariable Long id) {
    //     Optional<ExerciceAssociation> exerciceAssociation = exerciceAssociationService.findById(id);
    //     return exerciceAssociation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // @PostMapping
    // public ExerciceAssociation createExerciceAssociation(@RequestBody ExerciceAssociation exerciceAssociation) {
    //     return exerciceAssociationService.save(exerciceAssociation);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<ExerciceAssociation> updateExerciceAssociation(@PathVariable Long id, @RequestBody ExerciceAssociation exerciceAssociationDetails) {
    //     Optional<ExerciceAssociation> optionalExerciceAssociation = exerciceAssociationService.findById(id);
    //     if (optionalExerciceAssociation.isPresent()) {
    //         ExerciceAssociation exerciceAssociation = optionalExerciceAssociation.get();
    //         exerciceAssociation.setNiveauExercice(exerciceAssociationDetails.getNiveauExercice());
    //         exerciceAssociation.setTypeExercice(exerciceAssociationDetails.getTypeExercice());
    //         exerciceAssociation.setCategorie(exerciceAssociationDetails.getCategorie());
    //         exerciceAssociation.setEtapeRessources(exerciceAssociationDetails.getEtapeRessources());
    //         exerciceAssociation.setTache(exerciceAssociationDetails.getTache());
    //         exerciceAssociation.setTxtExplicationExerciceAssociation(exerciceAssociationDetails.getTxtExplicationExerciceAssociation());
    //         exerciceAssociation.setSndExplicationExerciceAssociation(exerciceAssociationDetails.getSndExplicationExerciceAssociation());
    //         exerciceAssociation.setTxtCommandeExerciceAssociation(exerciceAssociationDetails.getTxtCommandeExerciceAssociation());
    //         exerciceAssociation.setSndCommandeExerciceAssociation(exerciceAssociationDetails.getSndCommandeExerciceAssociation());
    //         exerciceAssociation.setTxtRegleAssociation(exerciceAssociationDetails.getTxtRegleAssociation());
    //         exerciceAssociation.setSndRegleAssociation(exerciceAssociationDetails.getSndRegleAssociation());
    //         exerciceAssociation.setTxtValidationExerciceAssociationOk(exerciceAssociationDetails.getTxtValidationExerciceAssociationOk());
    //         exerciceAssociation.setSndValidationExerciceAssociationOk(exerciceAssociationDetails.getSndValidationExerciceAssociationOk());
    //         exerciceAssociation.setTxtValidationExerciceAssociationKo(exerciceAssociationDetails.getTxtValidationExerciceAssociationKo());
    //         exerciceAssociation.setSndValidationExerciceAssociationKo(exerciceAssociationDetails.getSndValidationExerciceAssociationKo());
    //         return ResponseEntity.ok(exerciceAssociationService.save(exerciceAssociation));
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteExerciceAssociation(@PathVariable Long id) {
    //     if (exerciceAssociationService.findById(id).isPresent()) {
    //         exerciceAssociationService.deleteById(id);
    //         return ResponseEntity.noContent().build();
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
}
