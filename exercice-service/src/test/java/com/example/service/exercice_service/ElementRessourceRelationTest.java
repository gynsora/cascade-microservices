package com.example.service.exercice_service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.service.exercice_service.entity.Element;
import com.example.service.exercice_service.entity.Ressource;

public class ElementRessourceRelationTest {
    @Test
    public void testElementRessource() {
        //creation Ressource
        Ressource ressource = new Ressource();
        ressource.setId(1L);
        ressource.setNomRessource("composants");
        ressource.setGradeRessource(1);

        //creation Ressource
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

        //creation Element2
        Element element2 = new Element();
        element2.setId(2L);
        element2.setNomElement("poule");
        element2.setImgElement("poule.png");
        element2.setRessource(ressource2);

        // ajout regle association pour l'element1
        element1.addRegleAssociation(element2, 1);

        //assertion
        assertEquals(1L, element1.getId());
        assertEquals("oeuf", element1.getNomElement());
        assertEquals("oeuf.png", element1.getImgElement());
        assertEquals(ressource, element1.getRessource());
        assertEquals(1, element1.getCoutRessource().size());
    }
}
