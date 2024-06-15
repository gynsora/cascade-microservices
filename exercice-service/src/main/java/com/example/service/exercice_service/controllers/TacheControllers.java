package com.example.service.exercice_service.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.exercice_service.entity.Materiel;
import com.example.service.exercice_service.entity.Tache;
import com.example.service.exercice_service.services.TacheService;

@RestController
@RequestMapping("/taches")
public class TacheControllers {

    @Autowired
    private TacheService tacheService;

    @GetMapping
    public List<Tache> getAllTaches() {
        return tacheService.getAllTaches();
    }

    @GetMapping("/{id}")
    public Optional<Tache> getTacheById(@PathVariable Long id) {
        return tacheService.getTachesById(id);
    }

    @PostMapping
    public Tache createTache(@RequestBody Tache tache) {
        return tacheService.saveTache(tache);
    }

    @DeleteMapping("/{id}")
    public void deleteTache(@PathVariable Long id) {
        tacheService.deleteTache(id);
    }

    //On ajoute ce code pour ajouter des materiels pour une tache donnee
    @PostMapping("/{tacheId}/materiels")
    public ResponseEntity<?> addMaterielsToTache(@PathVariable Long tacheId, @RequestBody List<Materiel> materiels) {
        tacheService.addMaterielsToTache(tacheId, materiels);
        return ResponseEntity.ok().build();
    }

    // effacer un materiel d'une tache
    @DeleteMapping("/{tacheId}/materiels/{materielId}")
    public void removeMaterielFromTache(@PathVariable Long tacheId, @PathVariable Long materielId) {
        tacheService.removeMaterielFromTache(tacheId, materielId);
    }
}
