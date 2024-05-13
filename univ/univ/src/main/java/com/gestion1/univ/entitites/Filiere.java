package com.gestion1.univ.entitites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Filiere {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfil;
    private String nomfiliere;
    private int nombreEtudiants;
    private int nombreEnseignants;

    @Override
    public String toString() {
        return "Filiere{" +
                "idfil=" + idfil +
                ", nomfiliere='" + nomfiliere + '\'' +
                ", nombreEtudiants=" + nombreEtudiants +
                ", nombreEnseignants=" + nombreEnseignants +
                '}';
    }

    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants=new ArrayList<>();


    public Filiere() {
        super();
    }

    public Filiere(String nomfiliere, int nombreEtudiants, int nombreEnseignants) {
        this.nomfiliere = nomfiliere;
        this.nombreEtudiants = nombreEtudiants;
        this.nombreEnseignants = nombreEnseignants;
    }

    public Long getIdfil() {
        return idfil;
    }

    public void setIdfil(Long idfil) {
        this.idfil = idfil;
    }

    public String getNomfiliere() {
        return nomfiliere;
    }

    public void setNomfiliere(String nomfiliere) {
        this.nomfiliere = nomfiliere;
    }

    public int getNombreEtudiants() {
        return nombreEtudiants;
    }

    public void setNombreEtudiants(int nombreEtudiants) {
        this.nombreEtudiants = nombreEtudiants;
    }

    public int getNombreEnseignants() {
        return nombreEnseignants;
    }

    public void setNombreEnseignants(int nombreEnseignants) {
        this.nombreEnseignants = nombreEnseignants;
    }
}
