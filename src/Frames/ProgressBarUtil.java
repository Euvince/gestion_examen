/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

/**
 *
 * @author tata-h
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBarUtil {

    private final JFrame frame;
    private final JProgressBar progressBar;
    private final JLabel welcomeLabel; // Nouveau JLabel pour le message de bienvenue
    private final String taskName;

    public ProgressBarUtil(String taskName) {
        this.taskName = taskName;

        frame = new JFrame();
        frame.setUndecorated(true); // Enlever la barre de titre
        frame.setSize(600, 400); // Ajuster la taille pour le message de bienvenue
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        welcomeLabel = new JLabel("Bienvenu !", SwingConstants.CENTER); // Ajouter un label avec le message de bienvenue
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        frame.add(BorderLayout.CENTER, welcomeLabel); // Ajouter le label au nord (haut) de la fenêtre
        frame.add(BorderLayout.SOUTH, progressBar);

        Timer timer = new Timer(1000, new ActionListener() {
            int progress = 0;
            int maxProgress = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (progress <= maxProgress) {
                    progressBar.setValue(progress * (100 / maxProgress));
                    progressBar.setString(taskName + " - " + progressBar.getValue() + "%");
                    progress++;
                } else {
                    ((Timer) e.getSource()).stop();
                    frame.dispose(); // Fermer le JFrame après 30 secondes
                }
            }
        });

        timer.start();

        frame.setVisible(true);
        centerFrame(); // Appeler la méthode pour centrer la fenêtre
    }

    private void centerFrame() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - frame.getSize().width) / 2;
        int y = (dim.height - frame.getSize().height) / 2;
        frame.setLocation(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgressBarUtil("Chargement");
                simulateLongTask();
            }
        });
    }

    public static void simulateLongTask() {
        try {
            // Simulez une tâche longue en attendant pendant 30 secondes
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}