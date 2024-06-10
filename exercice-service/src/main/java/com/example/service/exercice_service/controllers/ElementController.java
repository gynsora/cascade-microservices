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

import com.example.service.exercice_service.entity.Element;
import com.example.service.exercice_service.services.ElementService;


@RestController
@RequestMapping("/elements")
public class ElementController {

    @Autowired
    private ElementService elementService;


    //get all
    @GetMapping
    public List<Element> getAllElements() {
        return elementService.getAllElements();
    }

    // get by id
    @GetMapping("/{id}")
    public Optional<Element> getElementById(@PathVariable Long id) {
        return elementService.getElementById(id);
    }

    //add
    @PostMapping
    public Element addElement(@RequestBody Element element) {
        return elementService.addElement(element);
    }
    //delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        elementService.deleteElement(id);
    }

    //update
    @PutMapping("/{id}")
    public Element update(@PathVariable Long id, @RequestBody Element element) {
        element.setId(id);
        return elementService.addElement(element);
    }
}
