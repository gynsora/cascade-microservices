package com.example.service.exercice_service.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

// @AllArgsConstructor //Génère automatiquement un constructeur par défaut avec tous les paramètres

@Getter
@Setter
@Entity
@NoArgsConstructor // Génère automatiquement un constructeur par défaut sans paramètres
@SuperBuilder
@Table(name = "ExerciceAssociations") // Indique la table correspondante dans la base de données
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues lors de la désérialisation JSON
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

    // Constructor using super() to initialize parent class fields
    // public ExerciceAssociation(Long idExercice, 
    //                             String niveauExercice ,
    //                             String typeExercice ,
    //                             Categorie categorie, 
    //                             List<Ressource> etapeRessources, 
    //                             Tache tache , 
    //                             String txtExplicationExerciceAssociation, 
    //                             String sndExplicationExerciceAssociation, 
    //                             String txtCommandeExerciceAssociation,
    //                             String sndCommandeExerciceAssociation,
    //                             String txtRegleAssociation,
    //                             String sndRegleAssociation,
    //                             String txtValidationExerciceAssociationOk,
    //                             String sndValidationExerciceAssociationOk,
    //                             String txtValidationExerciceAssociationKo,
    //                             String sndValidationExerciceAssociationKo
                            
    //                         ) {
    //     super(idExercice, niveauExercice, typeExercice,categorie, etapeRessources, tache);
    //     this.txtExplicationExerciceAssociation = txtExplicationExerciceAssociation;
    //     this.sndExplicationExerciceAssociation = sndExplicationExerciceAssociation;
    //     this.txtCommandeExerciceAssociation = txtCommandeExerciceAssociation;
    //     this.sndCommandeExerciceAssociation = sndCommandeExerciceAssociation;
    //     this.txtRegleAssociation = txtRegleAssociation;
    //     this.sndRegleAssociation = sndRegleAssociation;
    //     this.txtValidationExerciceAssociationOk = txtValidationExerciceAssociationOk;
    //     this.sndValidationExerciceAssociationOk = sndValidationExerciceAssociationOk;
    //     this.txtValidationExerciceAssociationKo = txtValidationExerciceAssociationKo;
    //     this.sndValidationExerciceAssociationKo = sndValidationExerciceAssociationKo;
    // }
    
}
