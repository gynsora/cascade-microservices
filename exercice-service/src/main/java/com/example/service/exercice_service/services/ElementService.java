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

    //save 
    public Element addElement(Element element) {
        // Vérifiez que la ressource existe
        if (ressourceRepository.existsById(element.getRessource().getId())) {
            validateElement(element);
            return elementRepository.save(element);
        } else {
            throw new IllegalArgumentException("La ressource de cet element n'existe pas");
        }
    }

    //delete
    public void deleteElement(Long id) {
        elementRepository.deleteById(id);
    }
    

    //ajouter une regle d'association
    public void addRegleAssociation(Long sourceId, Long enfantId, int quantite) {
        Optional<Element> sourceOpt = elementRepository.findById(sourceId);
        Optional<Element> enfantOpt = elementRepository.findById(enfantId);

        if (sourceOpt.isPresent() && enfantOpt.isPresent()) {
            Element source = sourceOpt.get();
            Element enfant = enfantOpt.get();
            source.addRegleAssociation(enfant, quantite);
            elementRepository.save(source);
        }
    }

    //enlever une regle d'association
    public void removeRegleAssociation(Long sourceId, Long enfantId) {
        Optional<Element> sourceOpt = elementRepository.findById(sourceId);
        Optional<Element> enfantOpt = elementRepository.findById(enfantId);

        if (sourceOpt.isPresent() && enfantOpt.isPresent()) {
            Element source = sourceOpt.get();
            Element enfant = enfantOpt.get();
            source.removeRegleAssociation(enfant);
            elementRepository.save(source);
        }
    }

    public void validateElement(Element element){
        if (element.getNomElement() == null || element.getNomElement().trim().isEmpty()) {
            throw new RuntimeException("Le nom de l'élément est obligatoire");
        }
        //on cherche si le nom de l'element est deja dans la bdd
        Optional<Element> elementAvecNomExistant = elementRepository.findByNomElement(element.getNomElement());
        if(elementAvecNomExistant.isPresent() ){
            Element elementSource = elementAvecNomExistant.get();
            if(elementSource.getId() != element.getId()){ // Pour la mise a jour on regarde si le nom de l'element (deja dans la bdd), à le meme Id que l'element a modifier, si oui pas de soucis, sinon a on a probleme
                throw new RuntimeException("Le nom de l'élément est deja présent dans la BDD");
            }
        }
    }

    
}
