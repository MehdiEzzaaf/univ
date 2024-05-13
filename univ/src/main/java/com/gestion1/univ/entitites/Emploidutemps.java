package com.gestion1.univ.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
public class Emploidutemps {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idemp;
    private String nomcours;
    private Date date;
    private int  heure;
    @ManyToOne
    private Cours cours;

    @ManyToOne
    private Enseignant enseignant;


    @Override
    public String toString() {
        return "Emploidutemps{" +
                "idemp=" + idemp +
                ", nomcours='" + nomcours + '\'' +
                ", date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                '}';
    }



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
