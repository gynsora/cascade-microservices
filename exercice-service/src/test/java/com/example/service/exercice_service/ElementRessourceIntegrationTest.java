package com.example.service.exercice_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.service.exercice_service.entity.Element;
import com.example.service.exercice_service.entity.RegleAssociation;
import com.example.service.exercice_service.entity.Ressource;
import com.example.service.exercice_service.repository.ElementRepository;
import com.example.service.exercice_service.repository.RegleAssociationRepository;
import com.example.service.exercice_service.repository.RessourceRepository;

import jakarta.transaction.Transactional;

@Transactional
@SpringBootTest
public class ElementRessourceIntegrationTest {

    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testElementRessourceRelationship() {
        List<RegleAssociation> reglesAssociation = new ArrayList<>();
        //creer une nouvelle ressource
        Ressource ressource = new Ressource();
        ressource.setId(1L);
        ressource.setNomRessource("composants");
        ressource.setGradeRessource(1);

        Ressource ressource2 = new Ressource();
        ressource2.setId(2L);
        ressource2.setNomRessource("materiaux");
        ressource2.setGradeRessource(2);

        //creation Element
        Element element1 = new Element();
        element1.setId(1L);
        element1.setNomElement("oeuf");
        element1.setImgElement("oeuf.png");
        element1.setRessource(ressource);


        Element element2 = new Element();
        element2.setId(2L);
        element2.setNomElement("poule");
        element2.setImgElement("poule.png");
        element2.setRessource(ressource2);

        //creation regle association pour l'element 1
        RegleAssociation regleAssociation1 = new RegleAssociation();
        regleAssociation1.setId(1L);
        regleAssociation1.setElementSource(element1);
        regleAssociation1.setElementEnfant(element2);
        regleAssociation1.setQuantite(1);

        //ajout de la regle dans la liste de regle d'association
        reglesAssociation.add(regleAssociation1);
        //ajout de la liste des regles d'association liés a element 1
        element1.setCoutRessource(reglesAssociation);
        //sauver l'element
        elementRepository.save(element1);

        element1 = elementRepository.findById(element1.getId()).orElse(null);
        //ArrayList<RegleAssociation> liste=(ArrayList<RegleAssociation>) regleAssociationRepository.findAll();

        // Assertions
        assertNotNull(element1);

        assertEquals(1, element1.getCoutRessource().size());
        assertEquals(ressource, element1.getRessource() );
    }
}
