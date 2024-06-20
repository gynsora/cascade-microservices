package com.example.service.exercice_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.service.exercice_service.repository.CategorieRepository;
import com.example.service.exercice_service.entity.Categorie;

@Service
@Transactional
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    //get all
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    //get by id
    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    //save
    public Categorie addCategorie(Categorie categorie) {
        validateCategorie(categorie);
        return categorieRepository.save(categorie);
    }

    //delete
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    

    private void validateCategorie(Categorie categorie) {
        if (categorie.getNomCategorie() == null || categorie.getNomCategorie().trim().isEmpty()) {
            throw new RuntimeException("Le nom de la catégorie est obligatoire");
        }
        if(categorieRepository.findByNomCategorie(categorie.getNomCategorie()).isPresent()){
            throw new RuntimeException("Le nom de la catégorie doit être unique");
        }
    }
}
