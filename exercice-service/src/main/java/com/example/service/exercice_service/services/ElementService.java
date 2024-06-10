package com.example.service.exercice_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.service.exercice_service.entity.Element;
import com.example.service.exercice_service.repository.ElementRepository;
import com.example.service.exercice_service.repository.RessourceRepository;

@Service
@Transactional
public class ElementService {
    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    private RessourceRepository ressourceRepository;

    //get all
    public List<Element> getAllElements() {
        return elementRepository.findAll();
    }

    //get by id
    public Optional<Element> getElementById(Long id) {
        return elementRepository.findById(id);
    }

    //save A CHANGER
    public Element addElement(Element element) {
        // Vérifiez que la ressource existe
        if (ressourceRepository.existsById(element.getRessource().getId())) {
            return elementRepository.save(element);
        } else {
            throw new IllegalArgumentException("La Ressource n'existe pas");
        }
    }

    //delete
    public void deleteElement(Long id) {
        elementRepository.deleteById(id);
    }
    

    //UPDATE ????

    
}
