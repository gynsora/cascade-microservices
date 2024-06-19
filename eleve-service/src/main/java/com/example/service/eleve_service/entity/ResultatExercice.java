package com.example.service.eleve_service.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "ResultatsExercices") // Indique la table correspondante dans la base de données
@AllArgsConstructor //Génère automatiquement un constructeur par défaut avec tous les paramètres
@NoArgsConstructor // Génère automatiquement un constructeur par défaut sans paramètres
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues lors de la désérialisation JSON
public class ResultatExercice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private int nbEssai ;
    private int tempsRequis; // en seconde
    private int nbConsultationRegle;
    private int nbConsulationCommande;

    private int idExercice; // cest le numero de l'exercice réalisé
    //Ajouter des attribut si nécessaire


    //liste de materiaux //cascade ?
    @ManyToOne
    @JoinColumn(name = "eleve_id")
    @JsonIgnore
    private Eleve eleve;

}   
