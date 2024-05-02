package gestionexamen;

import gestionexamen.Filiere;
import gestionexamen.Promotion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-29T13:18:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Etudiant.class)
public class Etudiant_ { 

    public static volatile SingularAttribute<Etudiant, String> emailEtudiant;
    public static volatile SingularAttribute<Etudiant, String> prenomEtudiant;
    public static volatile SingularAttribute<Etudiant, Promotion> idPromotion;
    public static volatile SingularAttribute<Etudiant, String> nomEtudiant;
    public static volatile SingularAttribute<Etudiant, Filiere> idFiliere;
    public static volatile SingularAttribute<Etudiant, String> sexeEtudiant;
    public static volatile SingularAttribute<Etudiant, Integer> ageEtudiant;
    public static volatile SingularAttribute<Etudiant, Integer> idEtudiant;

}