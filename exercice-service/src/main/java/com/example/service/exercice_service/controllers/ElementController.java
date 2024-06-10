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
import org.springframework.web.bind.annotation.RequestParam;
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
   

    @PutMapping("/{id}")
    public ResponseEntity<Element> updateElement(@PathVariable Long id, @RequestBody Element elementDetails) {
        Optional<Element> elementOpt = elementService.getElementById(id);
        if (elementOpt.isPresent()) {
            Element element = elementOpt.get();
            element.setNomElement(elementDetails.getNomElement());
            element.setImgElement(elementDetails.getImgElement());
            element.setRessource(elementDetails.getRessource()); // verifier si la nouvelle ressource fonctionne
            elementService.addElement(element);
            return ResponseEntity.ok(element);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@RequestParam  exemple =/1/ajoutRegleAssociation/2?quantite=1
    @PostMapping("/{sourceId}/ajoutRegleAssociation/{enfantId}")
    public ResponseEntity<Void> ajouterRegleAssociation(@PathVariable Long sourceId, @PathVariable Long enfantId, @RequestParam int quantite) {
        elementService.addRegleAssociation(sourceId, enfantId, quantite);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{sourceId}/supprimerRegleAssociation/{enfantId}")
    public ResponseEntity<Void> supprimerRegleAssociation(@PathVariable Long sourceId, @PathVariable Long enfantId) {
        elementService.removeRegleAssociation(sourceId, enfantId);
        return ResponseEntity.ok().build();
    }


    //delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        elementService.deleteElement(id);
    }
}
