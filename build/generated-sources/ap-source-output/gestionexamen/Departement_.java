package gestionexamen;

import gestionexamen.Filiere;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-29T13:18:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Departement.class)
public class Departement_ { 

    public static volatile SingularAttribute<Departement, String> nomDepartement;
    public static volatile SingularAttribute<Departement, Integer> idDepartement;
    public static volatile ListAttribute<Departement, Filiere> filiereList;

}