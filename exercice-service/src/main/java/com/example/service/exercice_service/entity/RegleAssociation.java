package com.example.service.exercice_service.entity;

import java.util.Objects;

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

@Data
@Entity// Indique que cette classe est une entité JPA
@Table(name = "RegleAssociations") // Indique la table correspondante dans la base de données
@AllArgsConstructor //Génère automatiquement un constructeur par défaut avec tous les paramètres
@NoArgsConstructor // Génère automatiquement un constructeur par défaut sans paramètres
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues lors de la désérialisation JSON
public class RegleAssociation {
    @Id // Indique que le champ suivant est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement la valeur de la clé primaire
    private Long id;

    
    //element parent
    @ManyToOne
    @JsonIgnore 
    @JoinColumn(name = "elementSource_id")
    private Element elementSource;

    //element enfant
    @ManyToOne
    @JoinColumn(name = "elementEnfant_id")
    private Element elementEnfant;
   
    private int quantite;

    public RegleAssociation(Element elementSource, Element elementEnfant, int quantite) {
        this.elementSource = elementSource;
        this.elementEnfant = elementEnfant;
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegleAssociation that = (RegleAssociation) o;
        return Objects.equals(elementSource, that.elementSource) &&
               Objects.equals(elementEnfant, that.elementEnfant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementSource, elementEnfant);
    }

    public void setElementSource(Element elementSource) {
        this.elementSource = elementSource;
    }

    public void setElementEnfant(Element elementEnfant) {
        this.elementEnfant = elementEnfant;
    }
}
