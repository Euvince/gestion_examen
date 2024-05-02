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
@Table(name = "promotion")
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findByIdPromotion", query = "SELECT p FROM Promotion p WHERE p.idPromotion = :idPromotion"),
    @NamedQuery(name = "Promotion.findByAnnee", query = "SELECT p FROM Promotion p WHERE p.annee = :annee")})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPromotion")
    private Integer idPromotion;
    @Basic(optional = false)
    @Column(name = "annee")
    private int annee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPromotion")
    private List<Etudiant> etudiantList;

    public Promotion() {
    }

    public Promotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Promotion(Integer idPromotion, int annee) {
        this.idPromotion = idPromotion;
        this.annee = annee;
    }

    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
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
        hash += (idPromotion != null ? idPromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.idPromotion == null && other.idPromotion != null) || (this.idPromotion != null && !this.idPromotion.equals(other.idPromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionexamen.Promotion[ idPromotion=" + idPromotion + " ]";
    }
    
}
