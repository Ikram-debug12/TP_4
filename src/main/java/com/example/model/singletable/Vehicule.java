package com.example.model.singletable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "vehicules")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categorie_vehicule", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifiant;

    @NotBlank(message = "La marque du véhicule est requise")
    private String marqueVehicule;

    @NotBlank(message = "Le modèle du véhicule est obligatoire")
    private String modeleVehicule;

    @NotNull(message = "Veuillez spécifier l'année de fabrication")
    @PastOrPresent(message = "L'année de fabrication ne peut pas être dans le futur")
    private LocalDate anneeFabrication;

    @NotNull(message = "Le prix de vente est nécessaire")
    @Positive(message = "Le prix doit être supérieur à zéro")
    private Double prixVehicule;

    // Constructeur par défaut requis par JPA
    public Vehicule() {
    }

    public Vehicule(String marqueVehicule, String modeleVehicule, LocalDate anneeFabrication, Double prixVehicule) {
        this.marqueVehicule = marqueVehicule;
        this.modeleVehicule = modeleVehicule;
        this.anneeFabrication = anneeFabrication;
        this.prixVehicule = prixVehicule;
    }

    // Getters et Setters
    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public String getMarqueVehicule() {
        return marqueVehicule;
    }

    public void setMarqueVehicule(String marqueVehicule) {
        this.marqueVehicule = marqueVehicule;
    }

    public String getModeleVehicule() {
        return modeleVehicule;
    }

    public void setModeleVehicule(String modeleVehicule) {
        this.modeleVehicule = modeleVehicule;
    }

    public LocalDate getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(LocalDate anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public Double getPrixVehicule() {
        return prixVehicule;
    }

    public void setPrixVehicule(Double prixVehicule) {
        this.prixVehicule = prixVehicule;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "identifiant=" + identifiant +
                ", marqueVehicule='" + marqueVehicule + '\'' +
                ", modeleVehicule='" + modeleVehicule + '\'' +
                ", anneeFabrication=" + anneeFabrication +
                ", prixVehicule=" + prixVehicule +
                '}';
    }
}
