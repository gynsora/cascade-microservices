package com.example.service.exercice_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.exercice_service.repository.MaterielRepository;
import com.example.service.exercice_service.repository.TacheRepository;
//import com.example.service.exercice_service.repository.ElementRepository;


//import com.example.service.exercice_service.entity.Element;
import com.example.service.exercice_service.entity.Materiel;
//import com.example.service.exercice_service.entity.Materiel;
import com.example.service.exercice_service.entity.Tache;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository ;

    @Autowired
    private MaterielRepository materielRepository ;

    // @Autowired
    // private ElementRepository elementRepository ;


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

    
    //Ici la tache pour ajouter du materiel a une tache
    public Tache addMaterielsToTache(Long tacheId, List<Materiel> materiels) {
        Tache tache = tacheRepository.findById(tacheId).orElseThrow(() -> new RuntimeException("Tache not found"));
        
        for (Materiel materiel : materiels) {
            materiel.setTache(tache);
            materielRepository.save(materiel);
        }
        
        return tache;
    }

    //enlever un materiel d'une tache
    public void removeMaterielFromTache(Long tacheId, Long materielId) {
        Materiel materiel = materielRepository.findById(materielId).orElse(null);
        if (materiel != null && materiel.getTache().getId().equals(tacheId)) {
            materielRepository.delete(materiel);
        }
    }
}
