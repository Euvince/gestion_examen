package gestionexamen;

import gestionexamen.Filiere;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-29T13:18:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Specialite.class)
public class Specialite_ { 

    public static volatile SingularAttribute<Specialite, Integer> idSpecialite;
    public static volatile SingularAttribute<Specialite, String> nomSpecialite;
    public static volatile SingularAttribute<Specialite, Filiere> idFiliere;

}