package com.gestion1.univ.entitites;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Emploidutemps {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idemp;
    private String nomcours;
    private Date date;
    private int  heure;

    @Override
    public String toString() {
        return "Emploidutemps{" +
                "idemp=" + idemp +
                ", nomcours='" + nomcours + '\'' +
                ", date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                '}';
    }


    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    public Emploidutemps() {
        super();
    }

    public Emploidutemps(String nomcours, Date date, int heure) {
        this.nomcours = nomcours;
        this.date = date;
        this.heure = heure;
    }

    public Long getIdemp() {
        return idemp;
    }

    public void setIdemp(Long idemp) {
        this.idemp = idemp;
    }

    public String getNomcours() {
        return nomcours;
    }

    public void setNomcours(String nomcours) {
        this.nomcours = nomcours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
}
