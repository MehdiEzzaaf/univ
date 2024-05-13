package com.gestion1.univ.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data

public class Enseignant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idens;
    private String nom;
    private String prenom;
    private int age;
    private String matiere;
    private String email;
    @OneToMany(mappedBy = "enseignant")
    private List<Emploidutemps> emploidutempsList;

    @OneToMany(mappedBy = "enseignant")
    private List<Cours> coursList;


    @Override
    public String toString() {
        return "Enseignant{" +
                "idens=" + idens +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", matiere='" + matiere + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



    public Enseignant() {
        super();
    }

    public Enseignant(String nom, String prenom, int age, String matiere,String email) {

        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.matiere = matiere;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getIdens() {
        return idens;
    }

    public void setIdens(Long idens) {
        this.idens = idens;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
}
