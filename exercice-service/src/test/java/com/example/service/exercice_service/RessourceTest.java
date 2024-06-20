package com.example.service.exercice_service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.service.exercice_service.entity.Ressource;

public class RessourceTest {
    
    @Test
    public void testRessourceGettersAndSetters() {
        Ressource ressource = new Ressource();
        ressource.setId(1L);
        ressource.setNomRessource("composants");
        ressource.setGradeRessource(1);

        assertEquals(1L, ressource.getId());
        assertEquals("composants", ressource.getNomRessource());
        assertEquals(1, ressource.getGradeRessource());
    }

}
