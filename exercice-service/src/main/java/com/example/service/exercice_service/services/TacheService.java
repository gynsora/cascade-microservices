package com.example.service.exercice_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.exercice_service.repository.MaterielRepository;
import com.example.service.exercice_service.repository.TacheRepository;
import com.example.service.exercice_service.repository.ElementRepository;


import com.example.service.exercice_service.entity.Element;
//import com.example.service.exercice_service.entity.Materiel;
import com.example.service.exercice_service.entity.Tache;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository ;

    // @Autowired
    // private MaterielRepository materielRepository ;

    @Autowired
    private ElementRepository elementRepository ;


    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    public Optional<Tache> getTachesById(Long id) {
        return tacheRepository.findById(id);
    }
    
    public Tache saveTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public void deleteTache(Long id) {
        tacheRepository.deleteById(id); 
    }

    // public void addMateriel(Long tacheId,Long elementId, int quantite,Boolean materielUtilisable) {
    //     Optional<Tache> tacheOpt = tacheRepository.findById(tacheId);
    //     Optional<Element> elementOpt = elementRepository.findById(elementId);
        
    //     if (elementOpt.isPresent() && tacheOpt.isPresent()) {
    //         Tache tache = tacheOpt.get();
    //         Element element = elementOpt.get();
    //         tache.addMateriel(element, quantite,materielUtilisable);
    //         tacheRepository.save(tache);
    //     }
    // }
}
