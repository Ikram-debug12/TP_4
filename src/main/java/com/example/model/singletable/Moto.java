package com.example.model.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("MOTO")
public class Moto extends Vehicule {

    @NotNull(message = "La cylindrée est requise")
    @Min(value = 50, message = "La cylindrée doit être au moins de 50cc")
    @Max(value = 2000, message = "La cylindrée ne peut pas dépasser 2000cc")
    private Integer cylindreeMoteur;

    private String typeTransmission;

    // Constructeur par défaut requis par JPA
    public Moto() {
    }

    public Moto(String marqueVehicule, String modeleVehicule, LocalDate anneeFabrication, Double prixVehicule,
                Integer cylindreeMoteur, String typeTransmission) {
        super(marqueVehicule, modeleVehicule, anneeFabrication, prixVehicule);
        this.cylindreeMoteur = cylindreeMoteur;
        this.typeTransmission = typeTransmission;
    }

    // Getters et Setters
    public Integer getCylindreeMoteur() {
        return cylindreeMoteur;
    }

    public void setCylindreeMoteur(Integer cylindreeMoteur) {
        this.cylindreeMoteur = cylindreeMoteur;
    }

    public String getTypeTransmission() {
        return typeTransmission;
    }

    public void setTypeTransmission(String typeTransmission) {
        this.typeTransmission = typeTransmission;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "identifiant=" + getIdentifiant() +
                ", marqueVehicule='" + getMarqueVehicule() + '\'' +
                ", modeleVehicule='" + getModeleVehicule() + '\'' +
                ", anneeFabrication=" + getAnneeFabrication() +
                ", prixVehicule=" + getPrixVehicule() +
                ", cylindreeMoteur=" + cylindreeMoteur +
                ", typeTransmission='" + typeTransmission + '\'' +
                '}';
    }
}