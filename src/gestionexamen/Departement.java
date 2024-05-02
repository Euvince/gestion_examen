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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Euvince
 */
@Entity
@Table(name = "departement")
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findByIdDepartement", query = "SELECT d FROM Departement d WHERE d.idDepartement = :idDepartement"),
    @NamedQuery(name = "Departement.findByNomDepartement", query = "SELECT d FROM Departement d WHERE d.nomDepartement = :nomDepartement")})
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepartement")
    private Integer idDepartement;
    @Basic(optional = false)
    @Column(name = "nomDepartement")
    private String nomDepartement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartement")
    private List<Filiere> filiereList;

    public Departement() {
    }

    public Departement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }

    public Departement(Integer idDepartement, String nomDepartement) {
        this.idDepartement = idDepartement;
        this.nomDepartement = nomDepartement;
    }

    public Integer getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public List<Filiere> getFiliereList() {
        return filiereList;
    }

    public void setFiliereList(List<Filiere> filiereList) {
        this.filiereList = filiereList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartement != null ? idDepartement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.idDepartement == null && other.idDepartement != null) || (this.idDepartement != null && !this.idDepartement.equals(other.idDepartement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionexamen.Departement[ idDepartement=" + idDepartement + " ]";
    }
    
}
