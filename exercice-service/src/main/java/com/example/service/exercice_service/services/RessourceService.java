package com.example.service.exercice_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.service.exercice_service.entity.Ressource;
import com.example.service.exercice_service.repository.RessourceRepository;




@Service
@Transactional
public class RessourceService {
    @Autowired
    private RessourceRepository ressourceRepository;

    //get all
    public List<Ressource> getAllRessources() {
        return ressourceRepository.findAll();
    }

    //get by id
    public Optional<Ressource> getRessourceById(Long id) {
        return ressourceRepository.findById(id);
    }

    //get by nom
    public Optional<Ressource> findByNomRessource(String nom) {
        return ressourceRepository.findByNomRessource(nom);
    }
    
    //save
    public Ressource addRessource(Ressource ressource) {
        //gerer si le nom de la ressource existe deja
        //return ressourceRepository.save(ressource);
        return ressourceRepository.save(ressource);
    }

    //delete
    public void deleteRessource(Long id) {
        ressourceRepository.deleteById(id);
    }

    //update ??
    // public Ressource updateRessource(Long id, Ressource updatedRessource) { 
    //     Optional<Ressource> existingRessource = ressourceRepository.findById(id);
    //     if (!existingRessource.isPresent()) {
    //         throw new IllegalArgumentException("il n'y a aucune ressource avec cet ID");
    //     }
    //     Ressource ressource = existingRessource.get();
    //     ressource.setGradeRessource(updatedRessource.getGradeRessource());            
    //     ressource.setNomRessource(updatedRessource.getNomRessource());            
    //     return ressourceRepository.save(ressource); 

    // }
    
}
