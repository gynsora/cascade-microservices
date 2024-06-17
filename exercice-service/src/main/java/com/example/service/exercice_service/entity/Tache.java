package com.example.service.exercice_service.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity// Indique que cette classe est une entité JPA
@Table(name = "Taches") // Indique la table correspondante dans la base de données
@AllArgsConstructor //Génère automatiquement un constructeur par défaut avec tous les paramètres
@NoArgsConstructor // Génère automatiquement un constructeur par défaut sans paramètres
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore les propriétés inconnues lors de la désérialisation JSON
public class Tache {
    @Id // Indique que le champ suivant est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement la valeur de la clé primaire
    private Long id;

    private String nomTache;

    //liste de materiaux //cascade ?
    @OneToMany(mappedBy = "tache", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Materiel> materiaux = new ArrayList<>();

    //ajout d'un nouveau materiel
    // public void addMateriel(Element element, int quantite,Boolean materielUtilisable) {
    //     Materiel nouveauMateriel = new Materiel(this, element, quantite,materielUtilisable);
    //     this.materiaux.add(nouveauMateriel);
    // }

    // public void removeRelation(Element elementEnfant) {
    //     ElementRelation relation = new ElementRelation(this, elementEnfant, 0);
    //     relationsAsSource.remove(relation);
    //     elementEnfant.getRelationsAsEnfant().remove(relation);
    //     relation.setElementSource(null);
    //     relation.setElementEnfant(null);
    // }

}
