package com.example.service.exercice_service.entity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity// Indique que cette classe est une entité JPA
@Table(name = "Elements") // Indique la table correspondante dans la base de données
@AllArgsConstructor //Génère automatiquement un constructeur par défaut avec tous les paramètres
@NoArgsConstructor // Génère automatiquement un constructeur par défaut sans paramètres
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues lors de la désérialisation JSON
public class Element {
    @Id // Indique que le champ suivant est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement la valeur de la clé primaire
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomElement;
    private String imgElement;

    //lie a une ressource //CASCADE ??
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "ressource_id", nullable = false)
    private Ressource ressource;

    //creer reflexive
    @OneToMany(mappedBy = "elementSource", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegleAssociation> CoutRessource = new ArrayList<>();

    //ajouter une regle d'association
    public void addRegleAssociation(Element elementEnfant, int quantite) {
        RegleAssociation relation = new RegleAssociation(this, elementEnfant, quantite);
        CoutRessource.add(relation);
    }

    //enlever une regle d'association
    public void removeRegleAssociation(Element elementEnfant) {
        RegleAssociation relation = new RegleAssociation(this, elementEnfant, 0);
        CoutRessource.remove(relation);
        relation.setElementSource(null);
    }

    //constructeur sans relations
    public Element(String nomElement, String imgElement, Ressource ressource){
        this.nomElement = nomElement;
        this.imgElement = imgElement;
        this.ressource = ressource;

    }
    
}
