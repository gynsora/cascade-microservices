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

import com.example.service.exercice_service.services.CategorieService;
import com.example.service.exercice_service.entity.Categorie;



@RestController
@RequestMapping("/categories")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    //get
    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/{id}")    
    public Optional<Categorie> getCategorieById(@PathVariable Long id) {        
        return categorieService.getCategorieById(id);   
    }

    //add
    @PostMapping
    public Categorie addCategorie(@RequestBody Categorie categorie) {
        return categorieService.addCategorie(categorie);
    }
    
    //delete
    @DeleteMapping("/{id}")    
    public void deleteCategorie(@PathVariable Long id) {        
        categorieService.deleteCategorie(id);    
    }

    //update
    @PutMapping("/{id}")    
    public Categorie updateCategorie(@PathVariable Long id, @RequestBody Categorie updatedCategorie) {        
        updatedCategorie.setId(id);
        return categorieService.addCategorie(updatedCategorie);
    }
}
