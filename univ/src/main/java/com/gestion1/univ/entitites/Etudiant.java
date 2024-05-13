package com.gestion1.univ.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idetud;
    private String prenom;
    private String nom;
    private int age;
    private String niveau;
    private String email;
    private String adress;
    @ManyToOne
    private Filiere filiere;


    public Etudiant() {
        super();
    }

    public Etudiant(String prenom, String nom, int age, String niveau, String email, String adress) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.niveau = niveau;
        this.email = email;
        this.adress = adress;



    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "idetud=" + idetud +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                ", niveau='" + niveau + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getIdetud() {
        return idetud;
    }

    public void setIdetud(Long idetud) {
        this.idetud = idetud;
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

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
