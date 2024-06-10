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
        return categorieRepository.save(categorie);
    }

    //delete
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    //update ??
    // public Categorie updateCategorie(Long id, Categorie updatedCategorie) { 
    //     Optional<Categorie> existingCategorie = categorieRepository.findById(id);
    //     if (!existingCategorie.isPresent()) {
    //         throw new IllegalArgumentException("Categorie with this ID does not exist");
    //     }
    //     Categorie categorie = existingCategorie.get();
    //     categorie.setNomCategorie(updatedCategorie.getNomCategorie());
    //     categorie.setImgCategorie(updatedCategorie.getImgCategorie());
    //     return categorieRepository.save(categorie);
    // }
}
