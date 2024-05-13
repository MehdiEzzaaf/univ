package com.gestion1.univ.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idcours;
        private String nom;
        private int heures;
        private Date date;
    @OneToMany(mappedBy = "cours")
    private List<Emploidutemps> emploidutempsList;

    @ManyToOne
    private Enseignant enseignant;

    @ManyToOne
    private Filiere filiere;

    @OneToMany(mappedBy = "cours")
    private List<Examen> examenList;

    @Override
    public String toString() {
        return "Cours{" +
                "idcours=" + idcours +
                ", nom='" + nom + '\'' +
                ", heures=" + heures +
                ", date=" + date +
                '}';
    }


    public Cours(String nom, int heures) {
        this.nom = nom;
        this.heures = heures;
    }

    public Long getIdcours() {
        return idcours;
    }

    public void setIdcours(Long idcours) {
        this.idcours = idcours;
    }

    public Cours() {
            super();
        }


        public Cours(String nom, int heures , Date date) {
            this.nom = nom;
            this.heures = heures;
            this.date=date;
        }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public int getHeures() {
            return heures;
        }

        public void setHeures(int heures) {
            this.heures = heures;
        }

       ;
        }






