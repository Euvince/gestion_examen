/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionexamen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Euvince
 */
@Entity
@Table(name = "filiere")
@NamedQueries({
    @NamedQuery(name = "Filiere.findAll", query = "SELECT f FROM Filiere f"),
    @NamedQuery(name = "Filiere.findByIdFiliere", query = "SELECT f FROM Filiere f WHERE f.idFiliere = :idFiliere"),
    @NamedQuery(name = "Filiere.findByNomFiliere", query = "SELECT f FROM Filiere f WHERE f.nomFiliere = :nomFiliere")})
public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFiliere")
    private Integer idFiliere;
    @Basic(optional = false)
    @Column(name = "nomFiliere")
    private String nomFiliere;
    @JoinColumn(name = "idDepartement", referencedColumnName = "idDepartement")
    @ManyToOne(optional = false)
    private Departement idDepartement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFiliere")
    private List<Specialite> specialiteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFiliere")
    private List<Etudiant> etudiantList;

    public Filiere() {
    }

    public Filiere(Integer idFiliere) {
        this.idFiliere = idFiliere;
    }

    public Filiere(Integer idFiliere, String nomFiliere) {
        this.idFiliere = idFiliere;
        this.nomFiliere = nomFiliere;
    }

    public Integer getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Integer idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public Departement getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Departement idDepartement) {
        this.idDepartement = idDepartement;
    }

    public List<Specialite> getSpecialiteList() {
        return specialiteList;
    }

    public void setSpecialiteList(List<Specialite> specialiteList) {
        this.specialiteList = specialiteList;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFiliere != null ? idFiliere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiere)) {
            return false;
        }
        Filiere other = (Filiere) object;
        if ((this.idFiliere == null && other.idFiliere != null) || (this.idFiliere != null && !this.idFiliere.equals(other.idFiliere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionexamen.Filiere[ idFiliere=" + idFiliere + " ]";
    }
    
}
