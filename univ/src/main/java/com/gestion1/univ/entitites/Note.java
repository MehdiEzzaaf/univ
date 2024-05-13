package com.gestion1.univ.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor

public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long idnote;
        private String matiere;
        private double valeur;
    @ManyToOne
    private Etudiant etudiant;




    @Override
    public String toString() {
        return "Note{" +
                "idnote=" + idnote +
                ", matiere='" + matiere + '\'' +
                ", valeur=" + valeur +
                '}';
    }

    public Long getIdnote() {
        return idnote;
    }

    public void setIdnote(Long idnote) {
        this.idnote = idnote;
    }

    public Note() {
            super();
        }



    public Note(String matiere, double valeur) {

            this.matiere = matiere;
            this.valeur = valeur;
        }


        public String getMatiere() {
            return matiere;
        }

        public void setMatiere(String matiere) {
            this.matiere = matiere;
        }

        public double getValeur() {
            return valeur;
        }

        public void setValeur(double valeur) {
            this.valeur = valeur;
        }





    }


