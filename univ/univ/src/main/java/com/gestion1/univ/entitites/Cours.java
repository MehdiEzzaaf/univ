package com.gestion1.univ.entitites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idcours;
        private String nom;
        private int heures;
        private Date date;

    @Override
    public String toString() {
        return "Cours{" +
                "idcours=" + idcours +
                ", nom='" + nom + '\'' +
                ", heures=" + heures +
                ", date=" + date +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;
    @ManyToMany(mappedBy = "coursSuivis")
    private List<Etudiant> etudiants = new ArrayList<>();


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






