package gestionexamen;

import gestionexamen.Etudiant;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-29T13:18:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Promotion.class)
public class Promotion_ { 

    public static volatile SingularAttribute<Promotion, Integer> idPromotion;
    public static volatile SingularAttribute<Promotion, Integer> annee;
    public static volatile ListAttribute<Promotion, Etudiant> etudiantList;

}