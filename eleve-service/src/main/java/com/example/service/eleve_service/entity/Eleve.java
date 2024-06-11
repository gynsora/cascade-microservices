package com.example.service.eleve_service.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity// Indique que cette classe est une entité JPA
@Table(name = "Eleves") // Indique la table correspondante dans la base de données
@AllArgsConstructor //Génère automatiquement un constructeur par défaut avec tous les paramètres
@NoArgsConstructor // Génère automatiquement un constructeur par défaut sans paramètres
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues lors de la désérialisation JSON
public class Eleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    // @Column(nullable = false)
    // private int age ;

    private String sexe;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String mdp;

    private String niveau ;

    // faire la liste des resultatsExercice de l'eleve  resultatsExercices: List<ResultatsExercice>

}
