/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.main.Main;
import com.tekeu.swing.Button;
import com.tekeu.swing.MyTextField;
import entity.Agenda;
import entity.Compte;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import model.AgendaModel;
import model.CompteModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author RAVEN
 */
public class Form_2 extends javax.swing.JPanel {

    private AgendaModel comptedb = new AgendaModel();
    private CompteModel produitdb = new CompteModel();
    private DefaultTableModel model = new DefaultTableModel();
    private Agenda prod;
    private Compte cmp;
    /**
     * Creates new form Form_1
     */
    public Form_2() {
        initComponents();
        initRegister();
        register.setVisible(true);
    }

    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Créer un évènement");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        
        MyTextField txtTitre = new MyTextField();
        txtTitre.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/title.png")));
        txtTitre.setHint("titre");
        register.add(txtTitre, "w 60%");
        
        JLabel labe = new JLabel("Description");
        register.add(labe);
       
        JTextArea txtDescription = new JTextArea();
        txtDescription.setBackground(Color.cyan);
        register.add(txtDescription, "w 60%");
        
        MyTextField lieu = new MyTextField();
        lieu.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/place.png")));
        lieu.setHint("Lieu");
        register.add(lieu, "w 60%");
        
        MyTextField date = new MyTextField();
        date.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/calendar.png")));
        date.setHint("date au format 'dd/MM/yyyy' ");
        register.add(date, "w 60%");
        
        MyTextField heure = new MyTextField();
        heure.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/9.png")));
        heure.setHint("date au format 'hh-mm-ssss'");
        register.add(heure, "w 60%");

        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("ENREGISTRER");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             String nom1 = txtTitre.getText();
             String mail = txtDescription.getText();
             String repon = lieu.getText();
             String pass = heure.getText();
             final java.sql.Date dat = new java.sql.Date(new Date().getTime());
                 prod = new Agenda(nom1, mail, pass, dat, repon);
                 comptedb.create(prod);
                 Main A = new Main();
                 A.show();
            }
            
        
        });
         register.add(cmd, "w 40%, h 40");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register = new javax.swing.JPanel();

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
