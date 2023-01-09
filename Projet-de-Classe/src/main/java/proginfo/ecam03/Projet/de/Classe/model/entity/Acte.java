package proginfo.ecam03.Projet.de.Classe.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Data
public class Acte implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String numero;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String lieuNaissance;
    private String nomPrenomPere;
    private String nomPrenomMere;

}