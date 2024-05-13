package com.gestion1.univ.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Table
@Entity
@Data
@AllArgsConstructor
@Builder
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idetud;
    private String prenom;
    private String nom;
    private int age;
    private String niveau;
    private String email;
    private String adress;

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
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Note> notes= new ArrayList<>() ;
    @ManyToOne
    @JoinColumn(name = "filiere_idfil")
    private Filiere filiere;
    @ManyToOne
    @JoinColumn(name = "enseignant_idens")
    private Enseignant enseignant;
    @ManyToOne
    @JoinColumn(name = "etablissement_id")
    private Etablissement etablissement;
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Emploidutemps> emploiDuTemps = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "etudiant_cours",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id"))
    private List<Cours> coursSuivis = new ArrayList<>();
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Examen> examens = new ArrayList<>();

    public Long getIdetud() {
        return idetud;
    }

    public void setIdetud(Long idetud) {
        this.idetud = idetud;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
                ", notes=" + notes +
                ", filiere=" + filiere +
                ", enseignant=" + enseignant +
                ", etablissement=" + etablissement +
                ", emploiDuTemps=" + emploiDuTemps +
                ", coursSuivis=" + coursSuivis +
                ", examens=" + examens +
                '}';
    }
}
