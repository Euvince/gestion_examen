/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionexamen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Euvince
 */
@Entity
@Table(name = "etudiant")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByIdEtudiant", query = "SELECT e FROM Etudiant e WHERE e.idEtudiant = :idEtudiant"),
    @NamedQuery(name = "Etudiant.findByNomEtudiant", query = "SELECT e FROM Etudiant e WHERE e.nomEtudiant = :nomEtudiant"),
    @NamedQuery(name = "Etudiant.findByPrenomEtudiant", query = "SELECT e FROM Etudiant e WHERE e.prenomEtudiant = :prenomEtudiant"),
    @NamedQuery(name = "Etudiant.findByEmailEtudiant", query = "SELECT e FROM Etudiant e WHERE e.emailEtudiant = :emailEtudiant"),
    @NamedQuery(name = "Etudiant.findBySexeEtudiant", query = "SELECT e FROM Etudiant e WHERE e.sexeEtudiant = :sexeEtudiant"),
    @NamedQuery(name = "Etudiant.findByAgeEtudiant", query = "SELECT e FROM Etudiant e WHERE e.ageEtudiant = :ageEtudiant")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEtudiant")
    private Integer idEtudiant;
    @Basic(optional = false)
    @Column(name = "nomEtudiant")
    private String nomEtudiant;
    @Basic(optional = false)
    @Column(name = "prenomEtudiant")
    private String prenomEtudiant;
    @Basic(optional = false)
    @Column(name = "emailEtudiant")
    private String emailEtudiant;
    @Basic(optional = false)
    @Column(name = "sexeEtudiant")
    private String sexeEtudiant;
    @Basic(optional = false)
    @Column(name = "ageEtudiant")
    private int ageEtudiant;
    @JoinColumn(name = "idFiliere", referencedColumnName = "idFiliere")
    @ManyToOne(optional = false)
    private Filiere idFiliere;
    @JoinColumn(name = "idPromotion", referencedColumnName = "idPromotion")
    @ManyToOne(optional = false)
    private Promotion idPromotion;

    public Etudiant() {
    }

    public Etudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Etudiant(Integer idEtudiant, String nomEtudiant, String prenomEtudiant, String emailEtudiant, String sexeEtudiant, int ageEtudiant) {
        this.idEtudiant = idEtudiant;
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.emailEtudiant = emailEtudiant;
        this.sexeEtudiant = sexeEtudiant;
        this.ageEtudiant = ageEtudiant;
    }

    public Integer getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public String getEmailEtudiant() {
        return emailEtudiant;
    }

    public void setEmailEtudiant(String emailEtudiant) {
        this.emailEtudiant = emailEtudiant;
    }

    public String getSexeEtudiant() {
        return sexeEtudiant;
    }

    public void setSexeEtudiant(String sexeEtudiant) {
        this.sexeEtudiant = sexeEtudiant;
    }

    public int getAgeEtudiant() {
        return ageEtudiant;
    }

    public void setAgeEtudiant(int ageEtudiant) {
        this.ageEtudiant = ageEtudiant;
    }

    public Filiere getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Filiere idFiliere) {
        this.idFiliere = idFiliere;
    }

    public Promotion getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Promotion idPromotion) {
        this.idPromotion = idPromotion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtudiant != null ? idEtudiant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.idEtudiant == null && other.idEtudiant != null) || (this.idEtudiant != null && !this.idEtudiant.equals(other.idEtudiant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionexamen.Etudiant[ idEtudiant=" + idEtudiant + " ]";
    }
    
}
