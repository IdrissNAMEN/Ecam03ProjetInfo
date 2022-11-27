package proginfo.ecam03.Projet.de.Classe.model.endity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Acte implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String nom;
    private String prenom;
    private String dateNaissance;
    private String lieuNaissance;
    private String lieuResidence;
    private String nomPrenomPere;
    private String professionPere;
    private String nomPrenomMere;
    private String professionMere;


    public Acte(long id) {
        this.id = id;
    }

    public Acte(String nom, String prenom, String dateNaissance, String lieuNaissance, String lieuResidence, String nomPrenomPere, String professionPere, String nomPrenomMere, String professionMere) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.lieuResidence = lieuResidence;
        this.nomPrenomPere = nomPrenomPere;
        this.professionPere = professionPere;
        this.nomPrenomMere = nomPrenomMere;
        this.professionMere = professionMere;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getLieuResidence() {
        return lieuResidence;
    }

    public void setLieuResidence(String lieuResidence) {
        this.lieuResidence = lieuResidence;
    }

    public String getNomPrenomPere() {
        return nomPrenomPere;
    }

    public void setNomPrenomPere(String nomPrenomPere) {
        this.nomPrenomPere = nomPrenomPere;
    }

    public String getProfessionPere() {
        return professionPere;
    }

    public void setProfessionPere(String professionPere) {
        this.professionPere = professionPere;
    }

    public String getNomPrenomMere() {
        return nomPrenomMere;
    }

    public void setNomPrenomMere(String nomPrenomMere) {
        this.nomPrenomMere = nomPrenomMere;
    }

    public String getProfessionMere() {
        return professionMere;
    }

    public void setProfessionMere(String professionMere) {
        this.professionMere = professionMere;
    }

    @Override
    public String toString() {
        return "Acte{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                ", lieuResidence='" + lieuResidence + '\'' +
                ", nomPrenomPere='" + nomPrenomPere + '\'' +
                ", professionPere='" + professionPere + '\'' +
                ", nomPrenomMere='" + nomPrenomMere + '\'' +
                ", professionMere='" + professionMere + '\'' +
                '}';
    }
}
