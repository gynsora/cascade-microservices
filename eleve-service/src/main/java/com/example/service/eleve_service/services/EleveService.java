package com.example.service.eleve_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.eleve_service.entity.Eleve;
import com.example.service.eleve_service.repository.EleveRepository;

@Service
public class EleveService {
    
    @Autowired
    private EleveRepository eleveRepository;

    public List<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    public Optional<Eleve> getEleveById(Long id) {
        return eleveRepository.findById(id);
    }

    public Eleve createEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    public Eleve updateEleve(Long id, Eleve eleveDetails) {
        Eleve eleve = eleveRepository.findById(id).orElseThrow(() -> new RuntimeException("Eleve not found"));
        eleve.setNom(eleveDetails.getNom());
        eleve.setPrenom(eleveDetails.getPrenom());
        eleve.setSexe(eleveDetails.getSexe());
        eleve.setEmail(eleveDetails.getEmail());
        eleve.setMdp(eleveDetails.getMdp());
        eleve.setNiveau(eleveDetails.getNiveau());
        
        return eleveRepository.save(eleve);
    }

    public void deleteEleve(Long id) {
        eleveRepository.deleteById(id);
    }
}
