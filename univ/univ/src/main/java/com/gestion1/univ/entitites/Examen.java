package com.gestion1.univ.entitites;

import jakarta.persistence.*;

@Entity
public class Examen {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idexam;
    private String matiere;
    private String type; // Exemple : écrit, oral
    private double note;

    @Override
    public String toString() {
        return "Examen{" +
                "idexam=" + idexam +
                ", matiere='" + matiere + '\'' +
                ", type='" + type + '\'' +
                ", note=" + note +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;
    public Long getIdexam() {
        return idexam;
    }

    public void setIdexam(Long idexam) {
        this.idexam = idexam;
    }


    public Examen() {
        super();
    }


    public Examen(String matiere, String type, double note) {
        this.matiere = matiere;
        this.type = type;
        this.note = note;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }


    }






