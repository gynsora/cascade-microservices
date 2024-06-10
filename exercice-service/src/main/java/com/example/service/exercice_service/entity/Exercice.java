package com.example.service.exercice_service.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Exercice {
    @Id // Indique que le champ suivant est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement la valeur de la clé primaire
    private Long idExercice;

    private String niveauExercice;
    private String typeExercice ;
    
    //creer une categories categorie (exercices)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "categorie_id")
    private Categorie categorie;
    
    //creer liste etaperessources (exercice) manytomany
    @ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="etape_exercices", joinColumns = @JoinColumn(name ="exercice_id"), inverseJoinColumns = @JoinColumn(name ="ressource_id") )
    private List<Ressource> etapeRessources = new ArrayList<>();


    //creer une taches tache (exercices)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "tache_id")
    private Tache tache;
    
}
