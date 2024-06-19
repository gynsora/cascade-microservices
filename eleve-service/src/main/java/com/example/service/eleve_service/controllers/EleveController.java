package com.example.service.eleve_service.controllers;

import java.util.List;

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

import com.example.service.eleve_service.entity.Eleve;
import com.example.service.eleve_service.entity.ResultatExercice;
import com.example.service.eleve_service.services.EleveService;

@RestController
@RequestMapping("/eleves")
public class EleveController {
    @Autowired
    private EleveService eleveService;

    @GetMapping
    public List<Eleve> getAllEleves() {
        return eleveService.getAllEleves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eleve> getEleveById(@PathVariable Long id) {
        return eleveService.getEleveById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Eleve createEleve(@RequestBody Eleve eleve) {
        return eleveService.createEleve(eleve);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eleve> updateEleve(@PathVariable Long id, @RequestBody Eleve eleveDetails) {
        return ResponseEntity.ok(eleveService.updateEleve(id, eleveDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEleve(@PathVariable Long id) {
        eleveService.deleteEleve(id);
        return ResponseEntity.noContent().build();
    }

    //On ajoute ce code pour ajouter des materiels pour une tache donnee
    @PostMapping("/{eleveId}/resultatsExercices")
    public ResponseEntity<?> addResultatExerciceToEleve(@PathVariable Long eleveId, @RequestBody List<ResultatExercice> resultatExercices) {
        eleveService.addResultatExerciceToEleve(eleveId, resultatExercices);
        return ResponseEntity.ok().build();
    }
    
     // effacer un materiel d'une tache
    @DeleteMapping("/{eleveId}/resultatsExercices/{resultatExerciceId}")
    public void removeResultatExerciceFromEleve(@PathVariable Long eleveId, @PathVariable Long resultatExerciceId) {
        eleveService.removeResultatExerciceFromEleve(eleveId, resultatExerciceId);
    }
}
