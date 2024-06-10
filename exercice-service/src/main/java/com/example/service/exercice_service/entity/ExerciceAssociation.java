package com.example.service.exercice_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor //Génère automatiquement un constructeur par défaut avec tous les paramètres
@NoArgsConstructor // Génère automatiquement un constructeur par défaut sans paramètres
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues lors de la désérialisation JSON
@Table(name = "ExerciceAssociations") // Indique la table correspondante dans la base de données
public class ExerciceAssociation extends Exercice{
    private String txtExplicationExerciceAssociation;
    private String sndExplicationExerciceAssociation;
    private String txtCommandeExerciceAssociation;
    private String sndCommandeExerciceAssociation;
    private String txtRegleAssociation ;
    private String sndRegleAssociation ;
    private String txtValidationExerciceAssociationOk ;
    private String sndValidationExerciceAssociationOk ;
    private String txtValidationExerciceAssociationKo ;
    private String sndValidationExerciceAssociationKo ;
    
}
