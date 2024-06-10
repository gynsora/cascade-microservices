package com.example.service.exercice_service.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.service.exercice_service.entity.Ressource;
import com.example.service.exercice_service.services.RessourceService;

@RestController
@RequestMapping("/ressources")
public class RessourceController {
    @Autowired
    private RessourceService ressourceService;

    //get
    @GetMapping
    public List<Ressource> getAllRessource() {
        return ressourceService.getAllRessources();
    }

    @GetMapping("/{id}")    
    public Optional<Ressource> getPersonById(@PathVariable Long id) {        
        return ressourceService.getRessourceById(id);   
    }

    //add
    @PostMapping
    public Ressource addRessource(@RequestBody Ressource ressource) {
        return ressourceService.addRessource(ressource);
    }
    
    //delete
    @DeleteMapping("/{id}")    
    public void deleteRessource(@PathVariable Long id) {        
        ressourceService.deleteRessource(id);    
    }

    //update
    @PutMapping("/{id}")    
    public Ressource updateRessource(@PathVariable Long id, @RequestBody Ressource updatedRessource) {        
        updatedRessource.setId(id);
        return ressourceService.addRessource(updatedRessource); 
    }
}
