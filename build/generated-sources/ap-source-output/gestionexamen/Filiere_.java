package gestionexamen;

import gestionexamen.Departement;
import gestionexamen.Etudiant;
import gestionexamen.Specialite;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-29T13:18:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Filiere.class)
public class Filiere_ { 

    public static volatile SingularAttribute<Filiere, String> nomFiliere;
    public static volatile ListAttribute<Filiere, Specialite> specialiteList;
    public static volatile SingularAttribute<Filiere, Integer> idFiliere;
    public static volatile SingularAttribute<Filiere, Departement> idDepartement;
    public static volatile ListAttribute<Filiere, Etudiant> etudiantList;

}