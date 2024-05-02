/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import gestionexamen.Departement;
import gestionexamen.Etudiant;
import gestionexamen.Filiere;
import gestionexamen.Promotion;
import gestionexamen.Specialite;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Euvince
 */
public class Dashboard extends javax.swing.JFrame {
    
    
    private final EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("GestionExamenPU");
    
    private final EntityManager entityManager = emf.createEntityManager();
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        
        initComponents();
        displayFilieresList();
        displayEtudiantsList();
        displayPromotionsList();
        displaySpecialitesList();
        displayDepartementsList();
        
        loadDataForFilieresComboBox();
        loadDataForPromotionsComboBox();
        loadDataForDepartementsComboBox();
        
    }
    
    private void createDepartement (Departement departement) {
        entityManager.getTransaction().begin();
        entityManager.persist(departement);
        entityManager.getTransaction().commit();
    }
    
    private void updateDepartement (Departement departement) {
        entityManager.getTransaction().begin();
        entityManager.merge(departement);
        entityManager.getTransaction().commit();
    }
    
    private void deleteDepartement (Departement departement) {
        entityManager.getTransaction().begin();
        entityManager.remove(departement);
        entityManager.getTransaction().commit();
    }
    
    private void createFiliere(Filiere filiere) {
        entityManager.getTransaction().begin();
        entityManager.persist(filiere);
        entityManager.getTransaction().commit();
    }
    
    private void updateFiliere (Filiere filiere) {
        entityManager.getTransaction().begin();
        entityManager.merge(filiere);
        entityManager.getTransaction().commit();
    }
    
    private void deleteFiliere (Filiere filiere) {
        entityManager.getTransaction().begin();
        entityManager.remove(filiere);
        entityManager.getTransaction().commit();
    }
    
    private void createSpecialite(Specialite specialite) {
        entityManager.getTransaction().begin();
        entityManager.persist(specialite);
        entityManager.getTransaction().commit();
    }
    
    private void updateSpecialite (Specialite specialite) {
        entityManager.getTransaction().begin();
        entityManager.merge(specialite);
        entityManager.getTransaction().commit();
    }
    
    private void deleteSpecialite (Specialite specialite) {
        entityManager.getTransaction().begin();
        entityManager.remove(specialite);
        entityManager.getTransaction().commit();
    }
    
    private void createPromotion(Promotion promotion) {
        entityManager.getTransaction().begin();
        entityManager.persist(promotion);
        entityManager.getTransaction().commit();
    }
    
    private void updatePromotion (Promotion promotion) {
        entityManager.getTransaction().begin();
        entityManager.merge(promotion);
        entityManager.getTransaction().commit();
    }
    
    private void deletePromotion (Promotion promotion) {
        entityManager.getTransaction().begin();
        entityManager.remove(promotion);
        entityManager.getTransaction().commit();
    }
    
    private void createEtudiant(Etudiant etudiant) {
        entityManager.getTransaction().begin();
        entityManager.persist(etudiant);
        entityManager.getTransaction().commit();
    }
    
    private void updateEtudiant (Etudiant etudiant) {
        entityManager.getTransaction().begin();
        entityManager.merge(etudiant);
        entityManager.getTransaction().commit();
    }
    
    private void deleteEtudiant (Etudiant etudiant) {
        entityManager.getTransaction().begin();
        entityManager.remove(etudiant);
        entityManager.getTransaction().commit();
    }
    
    private List<Departement> getAllDepartements () {
        Query jpql = entityManager.createNamedQuery("Departement.findAll");
        List<Departement> departements = jpql.getResultList();
        return departements;
    }
    
    private List<Filiere> getAllFilieres () {
        Query jpql = entityManager.createNamedQuery("Filiere.findAll");
        List<Filiere> filieres = jpql.getResultList();
        return filieres;
    }
    
    private List<Promotion> getAllPromotions () {
        Query jpql = entityManager.createNamedQuery("Promotion.findAll");
        List<Promotion> promotions = jpql.getResultList();
        return promotions;
    }
    
    private List<Specialite> getAllSpecialites () {
        Query jpql = entityManager.createNamedQuery("Specialite.findAll");
        List<Specialite> specialites = jpql.getResultList();
        return specialites;
    }
    
    private List<Etudiant> getAllEtudiants() {
        Query jpql = entityManager.createNamedQuery("Etudiant.findAll");
        List<Etudiant> etudiants = jpql.getResultList();
        return etudiants;
    }
    
    private Departement getDepartement (int id) {
        Query jpql = entityManager.createNamedQuery("Departement.findByIdDepartement");
        jpql.setParameter("idDepartement", id);
        Departement departement = (Departement) jpql.getSingleResult();
        return departement;
    }
    
    private Filiere getFiliere (int id) {
        Query jpql = entityManager.createNamedQuery("Filiere.findByIdFiliere");
        jpql.setParameter("idFiliere", id);
        Filiere filiere = (Filiere) jpql.getSingleResult();
        return filiere;
    }
    
    private Promotion getPromotion (int id) {
        Query jpql = entityManager.createNamedQuery("Promotion.findByIdPromotion");
        jpql.setParameter("idPromotion", id);
        Promotion promotion  = (Promotion) jpql.getSingleResult();
        return promotion;
    }
    
    private Specialite getSpecialite (int id) {
        Query jpql = entityManager.createNamedQuery("Specialite.findByIdSpecialite");
        jpql.setParameter("idSpecialite", id);
        Specialite specialite = (Specialite) jpql.getSingleResult();
        return specialite;
    }
    
    private Etudiant getEtudiant (int id) {
        Query jpql = entityManager.createNamedQuery("Etudiant.findByIdEtudiant");
        jpql.setParameter("idEtudiant", id);
        Etudiant etudiant = (Etudiant) jpql.getSingleResult();
        return etudiant;
    }
    
    
    
    private void displayDepartementsList () {
        
        String[] columns = {"ID", "NOM DU DÉPARTEMENT"};
        DefaultTableModel model = new DefaultTableModel(null, columns);
        
        searchDep.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent e) {
                filterDep();
            }
            
            @Override
            public void removeUpdate (DocumentEvent e) {
                filterDep();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterDep();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        List<Departement> departements = getAllDepartements();
        
        for (Departement d : departements) {
            Object[] row = {d.getIdDepartement(), d.getNomDepartement()};
            model.addRow(row);
        }
        
        departmentsTable.setModel(model);
        
    }
    
    private void displayFilieresList () {
        
        String[] columns = {"ID", "NOM DE LA FILIÈRE", "DÉPARTEMENT"};
        DefaultTableModel model = new DefaultTableModel(null, columns);
        
        searchFiliereField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent e) {
                filterFiliere();
            }
            
            @Override
            public void removeUpdate (DocumentEvent e) {
                filterFiliere();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterFiliere();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        List<Filiere> filieres = getAllFilieres();
        
        for (Filiere f : filieres) {
            Object[] row = {f.getIdFiliere(), f.getNomFiliere(), f.getIdDepartement().getNomDepartement()};
            model.addRow(row);
        }
        
        filieresTable.setModel(model);
        
    }
    
    private void displaySpecialitesList () {
        
        String[] columns = {"ID", "NOM DE LA SPÉCIALITÉ", "FILIÈRE"};
        DefaultTableModel model = new DefaultTableModel(null, columns);
        
        searchSpe.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent e) {
                filterSpe();
            }
            
            @Override
            public void removeUpdate (DocumentEvent e) {
                filterSpe();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterSpe();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        List<Specialite> specialites = getAllSpecialites();
        
        for (Specialite s : specialites) {
            Object[] row = {s.getIdSpecialite(), s.getNomSpecialite(), s.getIdFiliere().getNomFiliere()};
            model.addRow(row);
        }
        
        specialitesTable.setModel(model);
        
    }
    
    private void displayPromotionsList () {
        
        String[] columns = {"ID", "ANNÉE DE LA PROMOTION"};
        DefaultTableModel model = new DefaultTableModel(null, columns);
        
        searchPro.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent e) {
                filterPromotion();
            }
            
            @Override
            public void removeUpdate (DocumentEvent e) {
                filterPromotion();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterPromotion();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        List<Promotion> promotions = getAllPromotions();
        
        for (Promotion p : promotions) {
            Object[] row = {p.getIdPromotion(), p.getAnnee() + " - " + (p.getAnnee() + 1)};
            model.addRow(row);
        }
        
        promotionsTable.setModel(model);
        
    }
    
    private void displayEtudiantsList () {
        
        String[] columns = {"ID", "NOM", "PRÉNOMS", "EMAIL", "SEXE", "ÂGE", "FILIÈRE", "PROMO"};
        DefaultTableModel model = new DefaultTableModel(null, columns);
        
        searchEtu.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate (DocumentEvent e) {
                filterEtu();
            }
            
            @Override
            public void removeUpdate (DocumentEvent e) {
                filterEtu();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterEtu();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        List<Etudiant> etudiants = getAllEtudiants();
        
        for (Etudiant e : etudiants) {
            Object[] row = {
                e.getIdEtudiant(), 
                e.getNomEtudiant(), 
                e.getPrenomEtudiant(), 
                e.getEmailEtudiant(), 
                e.getSexeEtudiant(), 
                e.getAgeEtudiant(),
                e.getIdFiliere().getNomFiliere(),
                e.getIdPromotion().getAnnee()
            };
            model.addRow(row);
        }
        
        studentsTable.setModel(model);
        
    }
    
    private void loadDataForDepartementsComboBox () {
        
        depIds.removeAllItems();
        
        List<Departement> departements = getAllDepartements();
        
        for (Departement d : departements) {
            depIds.addItem(d.getNomDepartement());
        }
    }
    
    private void loadDataForFilieresComboBox () {
        
        filIds.removeAllItems();
        studentFilIds.removeAllItems();
                
        List<Filiere> filieres= getAllFilieres();
        
        for (Filiere f : filieres) {
            filIds.addItem(f.getNomFiliere());
            studentFilIds.addItem(f.getNomFiliere());
        }
    }
    
    private void loadDataForPromotionsComboBox () {
        
        studentProIds.removeAllItems();
        
        List<Promotion> promotions = getAllPromotions();
        
        for (Promotion p : promotions) {
            studentProIds.addItem(String.valueOf(p.getAnnee()));
        }
    }
    
    
     private boolean estFormatEmailValide(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        return email.matches(regex);
    }
     
    private boolean estAgeValide(String age) {
        // Valider que le champ contient uniquement des chiffres et est limité à deux chiffres
        return age.matches("^\\d{1,2}$") && Integer.parseInt(age) >= 16;
    }
    
    
    /*private void configureAnneeField() {
        JFormattedTextField = anneeTextField ((JTextField.DefaultEditor) anneePro.getEditor()).getTextField();
        anneeTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || anneeTextField.getText().length() == 4)  {
                    e.consume(); // Ignore non-digit characters
                }
            }
        });
    }*/
    
    /*private void configureNomTextField() {
        nomDep.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    e.consume(); // Ignore non-letter characters (excluding whitespaces)
                }
            }
        });
    }*/



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nomDep = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        departmenteditbutton = new javax.swing.JButton();
        departmentaddbutton = new javax.swing.JButton();
        departmentdeletebutton = new javax.swing.JButton();
        departmentresetbutton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        departmentsTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        searchDep = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        nomFil = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        filiereeditbutton = new javax.swing.JButton();
        filiereaddbutton = new javax.swing.JButton();
        filieredeletebutton = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        depIds = new javax.swing.JComboBox<>();
        filiereresetbutton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        filieresTable = new javax.swing.JTable();
        searchFiliereField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        nomSpe = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        specialiteeditbutton = new javax.swing.JButton();
        speciliateaddbutton = new javax.swing.JButton();
        specialitedeletebutton = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        filIds = new javax.swing.JComboBox<>();
        specialiteresetbutton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        specialitesTable = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        searchSpe = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        anneePro = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        promotioneditbutton = new javax.swing.JButton();
        promotionaddbutton = new javax.swing.JButton();
        promotiondeletebutton = new javax.swing.JButton();
        specialiteresetbutton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        promotionsTable = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        searchPro = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        studentfirstnametxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        studentlastnametxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        studenteditButton = new javax.swing.JButton();
        studentaddButton = new javax.swing.JButton();
        studentdeleteButton = new javax.swing.JButton();
        studentsextxt = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        studentoldtxt = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        studentemailtxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        studentFilIds = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        studentProIds = new javax.swing.JComboBox<>();
        studentresetbutton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchEtu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setForeground(new java.awt.Color(0, 153, 255));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INFORMATIONS RELATIVES AU DÉPARTEMENT");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nomDep.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomDep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomDepActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Nom");

        departmenteditbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        departmenteditbutton.setForeground(new java.awt.Color(255, 204, 51));
        departmenteditbutton.setText("ÉDITER");
        departmenteditbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmenteditbuttonActionPerformed(evt);
            }
        });

        departmentaddbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        departmentaddbutton.setForeground(new java.awt.Color(0, 153, 255));
        departmentaddbutton.setText("AJOUTER");
        departmentaddbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentaddbuttonActionPerformed(evt);
            }
        });

        departmentdeletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        departmentdeletebutton.setForeground(new java.awt.Color(255, 0, 51));
        departmentdeletebutton.setText("SUPPRIMER");
        departmentdeletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentdeletebuttonActionPerformed(evt);
            }
        });

        departmentresetbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        departmentresetbutton.setForeground(new java.awt.Color(0, 153, 153));
        departmentresetbutton.setText("RÉINITIALISER");
        departmentresetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentresetbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(departmentaddbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(departmenteditbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(departmentdeletebutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(departmentresetbutton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nomDep, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(48, 48, 48)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomDep, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentaddbutton)
                    .addComponent(departmenteditbutton)
                    .addComponent(departmentdeletebutton)
                    .addComponent(departmentresetbutton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        departmentsTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        departmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        departmentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departmentsTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                departmentsTableMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(departmentsTable);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Rechercher");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(searchDep, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchDep, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("DÉPARTEMENT", jPanel1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("INFORMATIONS RELATIVES À LA FILIÈRE");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nomFil.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomFil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomFilActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Nom");

        filiereeditbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filiereeditbutton.setForeground(new java.awt.Color(255, 204, 51));
        filiereeditbutton.setText("ÉDITER");
        filiereeditbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filiereeditbuttonActionPerformed(evt);
            }
        });

        filiereaddbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filiereaddbutton.setForeground(new java.awt.Color(0, 153, 255));
        filiereaddbutton.setText("AJOUTER");
        filiereaddbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filiereaddbuttonActionPerformed(evt);
            }
        });

        filieredeletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filieredeletebutton.setForeground(new java.awt.Color(255, 0, 51));
        filieredeletebutton.setText("SUPPRIMER");
        filieredeletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filieredeletebuttonActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Département");

        filiereresetbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filiereresetbutton.setForeground(new java.awt.Color(0, 153, 153));
        filiereresetbutton.setText("RÉINITIALISER");
        filiereresetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filiereresetbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(filiereaddbutton)
                        .addGap(18, 18, 18)
                        .addComponent(filiereeditbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filieredeletebutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filiereresetbutton))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(depIds, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nomFil, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addGap(48, 48, 48)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomFil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depIds, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filiereaddbutton)
                    .addComponent(filiereeditbutton)
                    .addComponent(filieredeletebutton)
                    .addComponent(filiereresetbutton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filieresTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        filieresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        filieresTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                filieresTableMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(filieresTable);

        searchFiliereField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFiliereFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchFiliereField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(searchFiliereField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("FILIÈRE", jPanel2);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("INFORMATIONS RELATIVES À LA SPÉCIALITÉ");
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nomSpe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomSpe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomSpe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomSpeActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Nom");

        specialiteeditbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        specialiteeditbutton.setForeground(new java.awt.Color(255, 204, 51));
        specialiteeditbutton.setText("ÉDITER");
        specialiteeditbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialiteeditbuttonActionPerformed(evt);
            }
        });

        speciliateaddbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        speciliateaddbutton.setForeground(new java.awt.Color(0, 153, 255));
        speciliateaddbutton.setText("AJOUTER");
        speciliateaddbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speciliateaddbuttonActionPerformed(evt);
            }
        });

        specialitedeletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        specialitedeletebutton.setForeground(new java.awt.Color(255, 0, 51));
        specialitedeletebutton.setText("SUPPRIMER");
        specialitedeletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialitedeletebuttonActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Filière");

        filIds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));

        specialiteresetbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        specialiteresetbutton.setForeground(new java.awt.Color(0, 153, 153));
        specialiteresetbutton.setText("RÉINITIALISER");
        specialiteresetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialiteresetbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(speciliateaddbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(specialiteeditbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(specialitedeletebutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(specialiteresetbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filIds, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nomSpe, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addGap(48, 48, 48)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomSpe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filIds, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speciliateaddbutton)
                    .addComponent(specialitedeletebutton)
                    .addComponent(specialiteeditbutton)
                    .addComponent(specialiteresetbutton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        specialitesTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        specialitesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        specialitesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                specialitesTableMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(specialitesTable);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Rechercher");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(57, 57, 57)
                        .addComponent(searchSpe, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 54, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchSpe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("SPÉCIALITÉ", jPanel3);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 153, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("INFORMATIONS RELATIVES À LA PROMOTION");
        jLabel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        anneePro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        anneePro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        anneePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anneeProActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Année de début");

        promotioneditbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        promotioneditbutton.setForeground(new java.awt.Color(255, 204, 51));
        promotioneditbutton.setText("ÉDITER");
        promotioneditbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promotioneditbuttonActionPerformed(evt);
            }
        });

        promotionaddbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        promotionaddbutton.setForeground(new java.awt.Color(0, 153, 255));
        promotionaddbutton.setText("AJOUTER");
        promotionaddbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promotionaddbuttonActionPerformed(evt);
            }
        });

        promotiondeletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        promotiondeletebutton.setForeground(new java.awt.Color(255, 0, 51));
        promotiondeletebutton.setText("SUPPRIMER");
        promotiondeletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promotiondeletebuttonActionPerformed(evt);
            }
        });

        specialiteresetbutton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        specialiteresetbutton1.setForeground(new java.awt.Color(0, 153, 153));
        specialiteresetbutton1.setText("RÉINITIALISER");
        specialiteresetbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialiteresetbutton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(promotionaddbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(promotioneditbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(promotiondeletebutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(specialiteresetbutton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(anneePro, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel23)
                .addGap(48, 48, 48)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anneePro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(promotionaddbutton)
                    .addComponent(promotioneditbutton)
                    .addComponent(promotiondeletebutton)
                    .addComponent(specialiteresetbutton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        promotionsTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        promotionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        promotionsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                promotionsTableMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(promotionsTable);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Rechercher");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(searchPro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchPro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PROMOTION", jPanel4);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("INFORMATIONS RELATIVES À L'ÉTUDIANT");
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        studentfirstnametxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        studentfirstnametxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentfirstnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentfirstnametxtActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Nom");

        studentlastnametxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        studentlastnametxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentlastnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentlastnametxtActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Prénoms");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Sexe");

        studenteditButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studenteditButton.setForeground(new java.awt.Color(255, 204, 51));
        studenteditButton.setText("ÉDITER");
        studenteditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studenteditButtonActionPerformed(evt);
            }
        });

        studentaddButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentaddButton.setForeground(new java.awt.Color(0, 153, 255));
        studentaddButton.setText("AJOUTER");
        studentaddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentaddButtonActionPerformed(evt);
            }
        });

        studentdeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentdeleteButton.setForeground(new java.awt.Color(255, 0, 51));
        studentdeleteButton.setText("SUPPRIMER");
        studentdeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentdeleteButtonActionPerformed(evt);
            }
        });

        studentsextxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        studentsextxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculin", "Féminin", "Autre" }));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Âge");

        studentoldtxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        studentoldtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentoldtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentoldtxtActionPerformed(evt);
            }
        });
        studentoldtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studentoldtxtKeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Email");

        studentemailtxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        studentemailtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentemailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentemailtxtActionPerformed(evt);
            }
        });
        studentemailtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studentemailtxtKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Filière");

        studentFilIds.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        studentFilIds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Promotion");

        studentProIds.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        studentresetbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentresetbutton.setForeground(new java.awt.Color(0, 153, 153));
        studentresetbutton.setText("RÉINITIALISER");
        studentresetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentresetbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentaddButton)
                        .addGap(38, 38, 38)
                        .addComponent(studenteditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentdeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(studentlastnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(studentfirstnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel14))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(studentsextxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(studentoldtxt)
                                            .addComponent(studentFilIds, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(studentProIds, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(studentemailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(studentresetbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentfirstnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentlastnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentemailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentsextxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentoldtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentFilIds, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentProIds, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentaddButton)
                    .addComponent(studenteditButton)
                    .addComponent(studentdeleteButton))
                .addGap(18, 18, 18)
                .addComponent(studentresetbutton)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        studentsTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        studentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                studentsTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(studentsTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Rechercher");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(searchEtu, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchEtu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("ÉTUDIANT", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentfirstnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentfirstnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentfirstnametxtActionPerformed

    private void studentlastnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentlastnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentlastnametxtActionPerformed

    private void studenteditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studenteditButtonActionPerformed
        try {
            if (studentfirstnametxt.getText().isEmpty() || 
                studentlastnametxt.getText().isEmpty() || 
                studentemailtxt.getText().isEmpty() || 
                studentoldtxt.getText().isEmpty() 
            ){
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }
            else if (!estFormatEmailValide(studentemailtxt.getText())) {
                JOptionPane.showMessageDialog(null, "Le format de l'email est invalide.");
            }
            else {
                Query jpql1 = entityManager.createNamedQuery("Filiere.findByNomFiliere");
                jpql1.setParameter("nomFiliere", studentFilIds.getSelectedItem().toString());
                Filiere filiere = (Filiere) jpql1.getSingleResult();

                Query jpql2 = entityManager.createNamedQuery("Promotion.findByAnnee");
                jpql2.setParameter("annee", Integer.parseInt(studentProIds.getSelectedItem().toString()));
                Promotion promotion = (Promotion) jpql2.getSingleResult();

                int i = studentsTable.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();
                Etudiant etudiant = getEtudiant((int)model.getValueAt(i, 0));
                etudiant.setNomEtudiant(studentfirstnametxt.getText());
                etudiant.setPrenomEtudiant(studentlastnametxt.getText());
                etudiant.setEmailEtudiant(studentemailtxt.getText());
                etudiant.setSexeEtudiant(studentsextxt.getSelectedItem().toString());
                etudiant.setAgeEtudiant(Integer.parseInt(studentoldtxt.getText()));
                etudiant.setIdFiliere(filiere);
                etudiant.setIdPromotion(promotion);
                updateEtudiant(etudiant);
                JOptionPane.showMessageDialog(null, "Modification de l'étudiant éffectuée avec succès");
                studentfirstnametxt.setText("");
                studentlastnametxt.setText("");
                studentemailtxt.setText("");
                studentsextxt.setSelectedIndex(0);
                studentoldtxt.setText("");
                studentFilIds.setSelectedIndex(0);
                studentProIds.setSelectedIndex(0);
                displayEtudiantsList();
            }
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la modification de l'étudiant");
        }
    }//GEN-LAST:event_studenteditButtonActionPerformed

    private void studentaddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentaddButtonActionPerformed
        try {
            if (studentfirstnametxt.getText().isEmpty() || 
                studentlastnametxt.getText().isEmpty() || 
                studentemailtxt.getText().isEmpty() || 
                studentoldtxt.getText().isEmpty() 
            ){
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }
            else if (!studentemailtxt.getText().isEmpty() && !estFormatEmailValide(studentemailtxt.getText())) {
                JOptionPane.showMessageDialog(null, "Le format de l'email est invalide.");
            }
            else {
                Query jpql1 = entityManager.createNamedQuery("Filiere.findByNomFiliere");
                jpql1.setParameter("nomFiliere", studentFilIds.getSelectedItem().toString());
                Filiere filiere = (Filiere) jpql1.getSingleResult();

                Query jpql2 = entityManager.createNamedQuery("Promotion.findByAnnee");
                jpql2.setParameter("annee", Integer.parseInt(studentProIds.getSelectedItem().toString()));
                Promotion promotion = (Promotion) jpql2.getSingleResult();

                Etudiant etudiant = new Etudiant();
                etudiant.setNomEtudiant(studentfirstnametxt.getText());
                etudiant.setPrenomEtudiant(studentlastnametxt.getText());
                etudiant.setEmailEtudiant(studentemailtxt.getText());
                etudiant.setSexeEtudiant(studentsextxt.getSelectedItem().toString());
                etudiant.setAgeEtudiant(Integer.parseInt(studentoldtxt.getText()));
                etudiant.setIdFiliere(filiere);
                etudiant.setIdPromotion(promotion);
                createEtudiant(etudiant);
                JOptionPane.showMessageDialog(null, "Ajout de l'étudiant éffectué avec succès");
                studentfirstnametxt.setText("");
                studentlastnametxt.setText("");
                studentemailtxt.setText("");
                studentsextxt.setSelectedIndex(0);
                studentoldtxt.setText("");
                studentFilIds.setSelectedIndex(0);
                studentProIds.setSelectedIndex(0);
                displayEtudiantsList();
            }
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de l'ajout de l'étudiant");
        }
    }//GEN-LAST:event_studentaddButtonActionPerformed

    private void studentdeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentdeleteButtonActionPerformed
        try {
            int i = studentsTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();
            Etudiant etudiant = getEtudiant((int)model.getValueAt(i, 0));
            deleteEtudiant(etudiant);
            JOptionPane.showMessageDialog(null, "Suppression de l'étudiant éffectuée avec succès");
            studentfirstnametxt.setText("");
            studentlastnametxt.setText("");
            studentemailtxt.setText("");
            studentsextxt.setSelectedIndex(0);
            studentoldtxt.setText("");
            studentFilIds.setSelectedIndex(0);
            studentProIds.setSelectedIndex(0);
            displayEtudiantsList();
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la suppression de l'étudiant");
        }
    }//GEN-LAST:event_studentdeleteButtonActionPerformed

    private void studentoldtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentoldtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentoldtxtActionPerformed

    private void studentsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMouseReleased
       int i = studentsTable.getSelectedRow();
       DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();
       Etudiant etudiant = getEtudiant((int)model.getValueAt(i, 0));
       
       studentfirstnametxt.setText(etudiant.getNomEtudiant());
       studentlastnametxt.setText(etudiant.getPrenomEtudiant());
       studentemailtxt.setText(etudiant.getEmailEtudiant());
       studentsextxt.setSelectedItem(etudiant.getSexeEtudiant());
       studentoldtxt.setText(String.valueOf(etudiant.getAgeEtudiant()));
       studentFilIds.setSelectedItem(etudiant.getIdFiliere().getNomFiliere());
       studentProIds.setSelectedItem(String.valueOf(etudiant.getIdPromotion().getAnnee()));
    }//GEN-LAST:event_studentsTableMouseReleased

    private void nomDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomDepActionPerformed

    private void departmenteditbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmenteditbuttonActionPerformed
        try {
            if (nomDep.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }else {
                int i = departmentsTable.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) departmentsTable.getModel();
                Departement departement = getDepartement((int)model.getValueAt(i, 0));
                departement.setNomDepartement(nomDep.getText());
                updateDepartement(departement);
                JOptionPane.showMessageDialog(null, "Modification du département éffectuée avec succès");
                nomDep.setText("");
                displayDepartementsList();
                loadDataForDepartementsComboBox();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la modification du département");
        }
    }//GEN-LAST:event_departmenteditbuttonActionPerformed

    private void departmentaddbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentaddbuttonActionPerformed
        try {
            if (nomDep.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }
            else {
                Departement departement = new Departement();
                departement.setNomDepartement(nomDep.getText());
                createDepartement(departement);
                JOptionPane.showMessageDialog(null, "Ajout du département éffectué avec succès");
                nomDep.setText("");
                displayDepartementsList();
                loadDataForDepartementsComboBox();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de l'ajout du département");
        }
    }//GEN-LAST:event_departmentaddbuttonActionPerformed

    private void departmentdeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentdeletebuttonActionPerformed
        try {
            int i = departmentsTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) departmentsTable.getModel();
            Departement departement = getDepartement((int)model.getValueAt(i, 0));
            deleteDepartement(departement);
            JOptionPane.showMessageDialog(null, "Suppresion du département éffectuée avec succès");
            nomDep.setText("");
            displayDepartementsList();
            loadDataForDepartementsComboBox();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la suppresion du département");
        }
    }//GEN-LAST:event_departmentdeletebuttonActionPerformed

    private void departmentsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmentsTableMouseReleased
        int i = departmentsTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) departmentsTable.getModel();
        Departement departement = getDepartement((int)model.getValueAt(i, 0));
        
        nomDep.setText(departement.getNomDepartement());
    }//GEN-LAST:event_departmentsTableMouseReleased

    private void nomFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomFilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomFilActionPerformed

    private void filiereeditbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filiereeditbuttonActionPerformed
        try {
            if (nomFil.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }else {
                Query jpql = entityManager.createNamedQuery("Departement.findByNomDepartement");
                jpql.setParameter("nomDepartement", depIds.getSelectedItem().toString());
                Departement departement = (Departement) jpql.getSingleResult();

                int i = filieresTable.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) filieresTable.getModel();
                Filiere filiere = getFiliere((int)model.getValueAt(i, 0));
                filiere.setNomFiliere(nomFil.getText());
                filiere.setIdDepartement(departement);
                updateFiliere(filiere);
                JOptionPane.showMessageDialog(null, "Modification de la filiere éffectuée avec succès");
                nomFil.setText("");
                depIds.setSelectedIndex(0);
                displayFilieresList();
                loadDataForFilieresComboBox();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la modification de la filiere");
        }
    }//GEN-LAST:event_filiereeditbuttonActionPerformed

    private void filiereaddbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filiereaddbuttonActionPerformed
       try {
            if (nomFil.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }else {
                Query jpql = entityManager.createNamedQuery("Departement.findByNomDepartement");
                jpql.setParameter("nomDepartement", depIds.getSelectedItem().toString());
                Departement departement = (Departement) jpql.getSingleResult();

                Filiere filiere = new Filiere();
                filiere.setNomFiliere(nomFil.getText());
                filiere.setIdDepartement(departement);
                createFiliere(filiere);
                JOptionPane.showMessageDialog(null, "Ajout de la filière éffectué avec succès");
                nomFil.setText("");
                depIds.setSelectedIndex(0);
                displayFilieresList();
                loadDataForFilieresComboBox();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de l'ajout de la filière");
        }
    }//GEN-LAST:event_filiereaddbuttonActionPerformed

    private void filieredeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filieredeletebuttonActionPerformed
        try {
            int i = filieresTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) filieresTable.getModel();
            Filiere filiere = getFiliere((int)model.getValueAt(i, 0));
            deleteFiliere(filiere);
            JOptionPane.showMessageDialog(null, "Suppresion de la filiere éffectuée avec succès");
            nomFil.setText("");
            depIds.setSelectedIndex(0);
            displayFilieresList();
            loadDataForFilieresComboBox();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la suppresion de la filiere");
        }
    }//GEN-LAST:event_filieredeletebuttonActionPerformed

    private void filieresTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filieresTableMouseReleased
        int i = filieresTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) filieresTable.getModel();
        Filiere filiere = getFiliere((int)model.getValueAt(i, 0));
        
        nomFil.setText(filiere.getNomFiliere());
        depIds.setSelectedItem(filiere.getIdDepartement().getNomDepartement());
    }//GEN-LAST:event_filieresTableMouseReleased

    private void anneeProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anneeProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anneeProActionPerformed

    private void promotioneditbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promotioneditbuttonActionPerformed
        try {
            if (anneePro.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }else {
                int i = promotionsTable.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) promotionsTable.getModel();
                Promotion promotion = getPromotion((int)model.getValueAt(i, 0));
                promotion.setAnnee(Integer.parseInt(anneePro.getText()));
                updatePromotion(promotion);
                JOptionPane.showMessageDialog(null, "Modification de la promotion éffectuée avec succès");
                anneePro.setText("");
                displayPromotionsList();
                loadDataForPromotionsComboBox();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la modification de la promotion");
        }
    }//GEN-LAST:event_promotioneditbuttonActionPerformed

    private void promotionaddbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promotionaddbuttonActionPerformed
        try {
            if (anneePro.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }else {
                Promotion promotion = new Promotion();
                promotion.setAnnee(Integer.parseInt(anneePro.getText()));
                createPromotion(promotion);
                JOptionPane.showMessageDialog(null, "Ajout de la promotion éffectué avec succès");
                anneePro.setText("");
                displayPromotionsList();
                loadDataForPromotionsComboBox();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de l'ajout de la promotion");
        }
    }//GEN-LAST:event_promotionaddbuttonActionPerformed

    private void promotiondeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promotiondeletebuttonActionPerformed
        try {
            int i = promotionsTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) promotionsTable.getModel();
            Promotion promotion = getPromotion((int)model.getValueAt(i, 0));
            deletePromotion(promotion);
            JOptionPane.showMessageDialog(null, "Suppresion de la promotion éffectuée avec succès");
            anneePro.setText("");
            displayPromotionsList();
            loadDataForPromotionsComboBox();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la suppresion de la promotion");
        }
    }//GEN-LAST:event_promotiondeletebuttonActionPerformed

    private void promotionsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_promotionsTableMouseReleased
        int i = promotionsTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) promotionsTable.getModel();
        Promotion promotion = getPromotion((int)model.getValueAt(i, 0));
        
        anneePro.setText(String.valueOf(promotion.getAnnee()));
    }//GEN-LAST:event_promotionsTableMouseReleased

    private void nomSpeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomSpeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomSpeActionPerformed

    private void specialiteeditbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialiteeditbuttonActionPerformed
        try {
            if (nomSpe.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }else {
                Query jpql = entityManager.createNamedQuery("Filiere.findByNomFiliere");
                jpql.setParameter("nomFiliere", filIds.getSelectedItem().toString());
                Filiere filiere = (Filiere) jpql.getSingleResult();

                int i = specialitesTable.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) specialitesTable.getModel();
                Specialite specialite = getSpecialite((int)model.getValueAt(i, 0));
                specialite.setNomSpecialite(nomSpe.getText());
                specialite.setIdFiliere(filiere);
                updateSpecialite(specialite);
                JOptionPane.showMessageDialog(null, "Modification de la spécialité éffectuée avec succès");
                nomSpe.setText("");
                filIds.setSelectedIndex(0);
                displaySpecialitesList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la modification de la spécialité");
        }
    }//GEN-LAST:event_specialiteeditbuttonActionPerformed

    private void speciliateaddbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speciliateaddbuttonActionPerformed
        try {
            if (nomSpe.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Remplissez tous les champs s'il vous plaît.");
            }else {
                Query jpql = entityManager.createNamedQuery("Filiere.findByNomFiliere");
                jpql.setParameter("nomFiliere", filIds.getSelectedItem().toString());
                Filiere filiere = (Filiere) jpql.getSingleResult();

                Specialite specialite = new Specialite();
                specialite.setNomSpecialite(nomSpe.getText());
                specialite.setIdFiliere(filiere);
                createSpecialite(specialite);
                JOptionPane.showMessageDialog(null, "Ajout de la specialite éffectué avec succès");
                nomSpe.setText("");
                filIds.setSelectedIndex(0);
                displaySpecialitesList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de l'ajout de la specialite");
        }
    }//GEN-LAST:event_speciliateaddbuttonActionPerformed

    private void specialitedeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialitedeletebuttonActionPerformed
        try {
            int i = specialitesTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) specialitesTable.getModel();
            Specialite specialite = getSpecialite((int)model.getValueAt(i, 0));
            deleteSpecialite(specialite);
            JOptionPane.showMessageDialog(null, "Suppresion de la spécialite éffectuée avec succès");
            nomSpe.setText("");
            filIds.setSelectedIndex(0);
            displaySpecialitesList();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Échec de la suppresion de la spécialite");
        }
    }//GEN-LAST:event_specialitedeletebuttonActionPerformed

    private void specialitesTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_specialitesTableMouseReleased
        int i = specialitesTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) specialitesTable.getModel();
        Specialite specialite = getSpecialite((int)model.getValueAt(i, 0));
        
        nomSpe.setText(specialite.getNomSpecialite());
        filIds.setSelectedItem(specialite.getIdFiliere().getNomFiliere());
    }//GEN-LAST:event_specialitesTableMouseReleased

    private void studentemailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentemailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentemailtxtActionPerformed

    private void departmentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmentsTableMouseClicked
        
    }//GEN-LAST:event_departmentsTableMouseClicked

    private void departmentresetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentresetbuttonActionPerformed
        nomDep.setText("");
    }//GEN-LAST:event_departmentresetbuttonActionPerformed

    private void filiereresetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filiereresetbuttonActionPerformed
        nomFil.setText("");
        depIds.setSelectedIndex(0);
    }//GEN-LAST:event_filiereresetbuttonActionPerformed

    private void specialiteresetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialiteresetbuttonActionPerformed
        nomSpe.setText("");
        filIds.setSelectedIndex(0);
    }//GEN-LAST:event_specialiteresetbuttonActionPerformed

    private void specialiteresetbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialiteresetbutton1ActionPerformed
        anneePro.setText("");
    }//GEN-LAST:event_specialiteresetbutton1ActionPerformed

    private void studentresetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentresetbuttonActionPerformed
        studentfirstnametxt.setText("");
        studentlastnametxt.setText("");
        studentemailtxt.setText("");
        studentsextxt.setSelectedIndex(0);
        studentoldtxt.setText("");
        studentFilIds.setSelectedIndex(0);
        studentProIds.setSelectedIndex(0);
    }//GEN-LAST:event_studentresetbuttonActionPerformed

    private void studentemailtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentemailtxtKeyReleased

        if (estFormatEmailValide(studentemailtxt.getText())) {
            studentemailtxt.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        } else {
            studentemailtxt.setBorder(BorderFactory.createLineBorder(Color.RED));
        }

        /*champsNonVides();*/

    }//GEN-LAST:event_studentemailtxtKeyReleased

    private void studentoldtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentoldtxtKeyReleased
        
        if (estAgeValide(studentoldtxt.getText())) {
            studentoldtxt.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        } else {
            studentoldtxt.setBorder(BorderFactory.createLineBorder(Color.RED));
        }

        /*champsNonVides();*/

    }//GEN-LAST:event_studentoldtxtKeyReleased

    private void searchFiliereFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFiliereFieldKeyReleased
        /*searchInFilieresDataTable();*/
    }//GEN-LAST:event_searchFiliereFieldKeyReleased

    
    private void filterFiliere () {
        String searchFiliereText = searchFiliereField.getText().toLowerCase();
        TableRowSorter<TableModel> sort = new TableRowSorter<>(filieresTable.getModel());
        filieresTable.setRowSorter(sort);
        if (searchFiliereText.trim().length() == 0) {
            sort.setRowFilter(null);
        }else {
            sort.setRowFilter(RowFilter.regexFilter("(?i)" + searchFiliereText));
        }
    }
    
    private void filterDep () {
        String searchDepText = searchDep.getText().toLowerCase();
        TableRowSorter<TableModel> sort = new TableRowSorter<>(departmentsTable.getModel());
        departmentsTable.setRowSorter(sort);
        if (searchDepText.trim().length() == 0) {
            sort.setRowFilter(null);
        }else {
            sort.setRowFilter(RowFilter.regexFilter("(?i)" + searchDepText));
        }
    }
    
    private void filterSpe () {
        String searchSpeText = searchSpe.getText().toLowerCase();
        TableRowSorter<TableModel> sort = new TableRowSorter<>(specialitesTable.getModel());
        specialitesTable.setRowSorter(sort);
        if (searchSpeText.trim().length() == 0) {
            sort.setRowFilter(null);
        }else {
            sort.setRowFilter(RowFilter.regexFilter("(?i)" + searchSpeText));
        }
    }
    
    private void filterPromotion() {
        String searchPromotionText = searchPro.getText().toLowerCase();
        TableRowSorter<TableModel> sort = new TableRowSorter<>(promotionsTable.getModel());
        promotionsTable.setRowSorter(sort);
        if (searchPromotionText.trim().length() == 0) {
            sort.setRowFilter(null);
        }else {
            sort.setRowFilter(RowFilter.regexFilter("(?i)" + searchPromotionText));
        }
    }
    
     private void filterEtu () {
        String searchEtuText = searchEtu.getText().toLowerCase();
        TableRowSorter<TableModel> sort = new TableRowSorter<>(studentsTable.getModel());
        studentsTable.setRowSorter(sort);
        if (searchEtuText.trim().length() == 0) {
            sort.setRowFilter(null);
        }else {
            sort.setRowFilter(RowFilter.regexFilter("(?i)" + searchEtuText));
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dashboard d = new Dashboard();
                d.setVisible(true);
                d.setLocationRelativeTo(null);
                d.pack();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anneePro;
    private javax.swing.JComboBox<String> depIds;
    private javax.swing.JButton departmentaddbutton;
    private javax.swing.JButton departmentdeletebutton;
    private javax.swing.JButton departmenteditbutton;
    private javax.swing.JButton departmentresetbutton;
    private javax.swing.JTable departmentsTable;
    private javax.swing.JComboBox<String> filIds;
    private javax.swing.JButton filiereaddbutton;
    private javax.swing.JButton filieredeletebutton;
    private javax.swing.JButton filiereeditbutton;
    private javax.swing.JButton filiereresetbutton;
    private javax.swing.JTable filieresTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nomDep;
    private javax.swing.JTextField nomFil;
    private javax.swing.JTextField nomSpe;
    private javax.swing.JButton promotionaddbutton;
    private javax.swing.JButton promotiondeletebutton;
    private javax.swing.JButton promotioneditbutton;
    private javax.swing.JTable promotionsTable;
    private javax.swing.JTextField searchDep;
    private javax.swing.JTextField searchEtu;
    private javax.swing.JTextField searchFiliereField;
    private javax.swing.JTextField searchPro;
    private javax.swing.JTextField searchSpe;
    private javax.swing.JButton specialitedeletebutton;
    private javax.swing.JButton specialiteeditbutton;
    private javax.swing.JButton specialiteresetbutton;
    private javax.swing.JButton specialiteresetbutton1;
    private javax.swing.JTable specialitesTable;
    private javax.swing.JButton speciliateaddbutton;
    private javax.swing.JComboBox<String> studentFilIds;
    private javax.swing.JComboBox<String> studentProIds;
    private javax.swing.JButton studentaddButton;
    private javax.swing.JButton studentdeleteButton;
    private javax.swing.JButton studenteditButton;
    private javax.swing.JTextField studentemailtxt;
    private javax.swing.JTextField studentfirstnametxt;
    private javax.swing.JTextField studentlastnametxt;
    private javax.swing.JTextField studentoldtxt;
    private javax.swing.JButton studentresetbutton;
    private javax.swing.JTable studentsTable;
    private javax.swing.JComboBox<String> studentsextxt;
    // End of variables declaration//GEN-END:variables
}
