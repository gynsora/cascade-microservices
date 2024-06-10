package com.example.service.exercice_service.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity// Indique que cette classe est une entité JPA
@Table(name = "Ressources") // Indique la table correspondante dans la base de données
@AllArgsConstructor //Génère automatiquement un constructeur par défaut avec tous les paramètres
@NoArgsConstructor // Génère automatiquement un constructeur par défaut sans paramètres
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues lors de la désérialisation JSON
public class Ressource {
    @Id // Indique que le champ suivant est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement la valeur de la clé primaire
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomRessource;
    @Column(nullable = false, unique = true)
    private int gradeRessource;

  

    
}
