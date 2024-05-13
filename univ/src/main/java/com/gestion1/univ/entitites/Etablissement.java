package com.gestion1.univ.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor


public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtab;
    private String nom;
    private String adresse;
    private String typeEtablissement;
    @OneToMany(mappedBy = "etablissement")
    private List<Filiere> filieres;


    @Override
    public String toString() {
        return "Etablissement{" +
                "idEtab=" + idEtab +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", typeEtablissement='" + typeEtablissement + '\'' +
                '}';
    }



    public Etablissement() {
        super();
    }

    public Etablissement(String nom, String adresse, String typeEtablissement) {
        this.nom = nom;
        this.adresse = adresse;
        this.typeEtablissement = typeEtablissement;
    }

    public Long getIdEtab() {
        return idEtab;
    }

    public void setIdEtab(Long idEtab) {
        this.idEtab = idEtab;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTypeEtablissement() {
        return typeEtablissement;
    }

    public void setTypeEtablissement(String typeEtablissement) {
        this.typeEtablissement = typeEtablissement;
    }
}
