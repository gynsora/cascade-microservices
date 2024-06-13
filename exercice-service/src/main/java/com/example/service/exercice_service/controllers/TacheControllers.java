package com.example.service.exercice_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
