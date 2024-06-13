package com.example.service.exercice_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity// Indique que cette classe est une entité JPA
@Table(name = "Materiaux") // Indique la table correspondante dans la base de données
@AllArgsConstructor //Génère automatiquement un constructeur par défaut avec tous les paramètres
@NoArgsConstructor // Génère automatiquement un constructeur par défaut sans paramètres
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues lors de la désérialisation JSON
public class Materiel {
    @Id // Indique que le champ suivant est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement la valeur de la clé primaire
    private Long id;

    //lie a une tache
    @ManyToOne(fetch = FetchType.LAZY)
    private Tache tache;
    //lie a un element
    @ManyToOne(fetch = FetchType.LAZY)
    private Element element;

    private int quantite;

    private Boolean materielUtilisable;

    // public Materiel(Tache tache, Element element,int quantite, Boolean materielUtilisable) {
    //     this.tache = tache;
    //     this.element  = element;
    //     this.quantite = quantite;
    //     this.materielUtilisable = materielUtilisable;
    // }
}
