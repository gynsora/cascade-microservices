package com.example.service.eleve_service.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.service.eleve_service.entity.Eleve;
import com.example.service.eleve_service.entity.ResultatExercice;
import com.example.service.eleve_service.repository.EleveRepository;
import com.example.service.eleve_service.repository.ResultatExerciceRepository;



@Service
@Transactional
public class EleveService {
    
    @Autowired
    private EleveRepository eleveRepository;

    @Autowired
    private ResultatExerciceRepository resultatExerciceRepository;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
        Pattern.CASE_INSENSITIVE
    );

    public List<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    public Optional<Eleve> getEleveById(Long id) {
        return eleveRepository.findById(id);
    }

    public Eleve createEleve(Eleve eleve) {
        //faire les vérifications de chaque attribut avant de faire le return
        validateEleve(eleve);
        if(eleveRepository.findByEmail(eleve.getEmail()).isPresent()  ){
            throw new RuntimeException("L'email ne doit pas déjà exister");
        }
        try {
            //eleve.setMotDePasse(passwordEncoder.encode(eleve.getMotDePasse()));
            return eleveRepository.save(eleve);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'enregistrement de l'élève", e);
        }
        //return eleveRepository.save(eleve);

    }

    public void deleteEleve(Long id) {
        eleveRepository.deleteById(id);
    }
    
    //mettre a jour les données d'un eleve (sans prendre en compte la liste de ces exercice realisé)
    public Eleve updateEleve(Long id, Eleve eleveDetails) {
        validateEleve(eleveDetails);
        try{
            Eleve eleve = eleveRepository.findById(id).orElseThrow(() -> new RuntimeException("Eleve non existant"));
            eleve.setNom(eleveDetails.getNom());
            eleve.setPrenom(eleveDetails.getPrenom());
            eleve.setSexe(eleveDetails.getSexe());
            eleve.setEmail(eleveDetails.getEmail()); 
            eleve.setNiveau(eleveDetails.getNiveau());
            //securiser le mdp
            eleve.setMdp(eleveDetails.getMdp());
            return eleveRepository.save(eleve);
        }catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise à jour de l'élève", e);
        }
        
    }

    //Ici ajouter une liste d'exercice réalisé par l'eleve
    public Eleve addResultatExerciceToEleve(Long eleveId, List<ResultatExercice> resultatExercices) {
        Eleve eleve = eleveRepository.findById(eleveId).orElseThrow(() -> new RuntimeException("Eleve not found"));
        
        for (ResultatExercice resultatExercice : resultatExercices) {
            resultatExercice.setEleve(eleve); 
            resultatExerciceRepository.save(resultatExercice);
        }
        
        return eleve;
    }

    //enlever un resultat d'exercice d'un eleve
    public void removeResultatExerciceFromEleve(Long eleveId, Long resultatExerciceId) {
        ResultatExercice resultatExercice = resultatExerciceRepository.findById(resultatExerciceId).orElse(null);
        if (resultatExercice != null && resultatExercice.getEleve().getId().equals(eleveId)) {
            resultatExerciceRepository.delete(resultatExercice);
        }
    }
    
    //verfie les attribut de l'eleve
    private void validateEleve(Eleve eleve) {
        if (eleve.getNom() == null || eleve.getNom().trim().isEmpty()) {
            throw new RuntimeException("Le nom est obligatoire");
        }
        if (eleve.getPrenom() == null || eleve.getPrenom().trim().isEmpty()) {
            throw new RuntimeException("Le prénom est obligatoire");
        }
        if (eleve.getSexe() == null || eleve.getSexe().trim().isEmpty()) {
            throw new RuntimeException("Le sexe est obligatoire");
        }
        if (eleve.getEmail() == null || eleve.getEmail().trim().isEmpty()) {
            throw new RuntimeException("L'email est obligatoire");
        }
        if (!EMAIL_PATTERN.matcher(eleve.getEmail()).matches()) {
            throw new RuntimeException("L'email doit être valide");
        }
        if (eleve.getMdp() == null || eleve.getMdp().trim().isEmpty()) {
            throw new RuntimeException("Le mot de passe est obligatoire");
        }
        // Add more validation rules as needed
    }

}
