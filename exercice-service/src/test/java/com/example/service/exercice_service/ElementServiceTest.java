package com.example.service.exercice_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.service.exercice_service.entity.Element;
import com.example.service.exercice_service.entity.Ressource;
import com.example.service.exercice_service.repository.ElementRepository;
import com.example.service.exercice_service.repository.RessourceRepository;
import com.example.service.exercice_service.services.ElementService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ElementServiceTest {
    @Mock
    private ElementRepository elementRepository;

    @Mock
    private RessourceRepository ressourceRepository;

    @InjectMocks
    private ElementService elementService;

    @Test
    void testGetAllElements() {
        //creation des ressources
        Ressource ressource1 = new Ressource();
        ressource1.setId(1L);
        ressource1.setNomRessource("composants");
        ressource1.setGradeRessource(1);

        Ressource ressource2 = new Ressource();
        ressource2.setId(2L);
        ressource2.setNomRessource("materiaux");
        ressource2.setGradeRessource(2);

        //creation des elements
        //creation Element
        Element element1 = new Element();
        element1.setId(1L);
        element1.setNomElement("oeuf");
        element1.setImgElement("oeuf.png");
        element1.setRessource(ressource1);


        Element element2 = new Element();
        element2.setId(2L);
        element2.setNomElement("poule");
        element2.setImgElement("poule.png");
        element2.setRessource(ressource2);

        when(elementRepository.findAll()).thenReturn(Arrays.asList(element1, element2));

        List<Element> elements = elementService.getAllElements();

        assertEquals(2, elements.size());
        assertEquals("oeuf", elements.get(0).getNomElement());
        assertEquals("poule", elements.get(1).getNomElement());
    }




}
