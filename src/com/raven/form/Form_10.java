package com.raven.form;


import com.tekeu.swing.Button;
import com.tekeu.swing.MyPasswordField;
import com.tekeu.swing.MyTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import entity.*;
import java.util.Date;
import model.*;

/**
 *
 * @author tekeu
 */
public class Form_10 extends javax.swing.JPanel {

                    
    private CompteModel comptedb = new  CompteModel();
    private DefaultTableModel model = new DefaultTableModel();
    private Compte cmp;
    private Form_Home form1 = new Form_Home();
                
    
    /**
     * Creates new form Form_1
     */
    public Form_10() {
        initComponents();
        initRegister();
        register.setVisible(true);
        
    }

    private void initRegister() {
     /*int i ;
        comptedb.readCompte(cmp.getIdCompte());
        i = cmp.getIdCompte();*/
        
            
            register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
            JLabel label = new JLabel("Mes Informations");
            label.setFont(new Font("sansserif", 1, 30));
            label.setForeground(new Color(7, 164, 121));
            register.add(label);
            MyTextField txtUser = new MyTextField();
            txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tekeu/icon/user.png")));
            txtUser.setHint("nom");
            register.add(txtUser, "w 60%");
            MyTextField txtEmail = new MyTextField();
            txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tekeu/icon/mail.png")));
            txtEmail.setHint("Email");
            register.add(txtEmail, "w 60%");
            MyTextField date = new MyTextField();
            date.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tekeu/icon/calendar.png")));
            date.setHint("date de naissance au format 'dd/MM/yyyy' ");
            register.add(date, "w 60%");
            MyPasswordField txtPass = new MyPasswordField();
            txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tekeu/icon/pass.png")));
            txtPass.setHint("mot de passe");
            register.add(txtPass, "w 60%");
            MyTextField txtphrasec = new MyTextField();
            txtphrasec.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tekeu/icon/question.png")));
            txtphrasec.setHint("Question secrete");
            register.add(txtphrasec, "w 60%");
            MyTextField reponse = new MyTextField();
            reponse.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tekeu/icon/reponse.png")));
            reponse.setHint("reponse");
            register.add(reponse, "w 60%");
            Button cmd = new Button();
            cmd.setBackground(new Color(7, 164, 121));
            cmd.setForeground(new Color(250, 250, 250));
            cmd.setText("S'INSCRIRE");
            cmd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                 String nom1 = txtUser.getText();
                 String mail = txtEmail.getText();
                 String phrasec = txtphrasec.getText();
                 String repon = reponse.getText();
                 String pass = txtPass.getText();
                 final java.sql.Date dat = new java.sql.Date(new Date().getTime());
                     cmp = new Compte(nom1, mail, dat,pass, phrasec, repon);
                     comptedb.update(cmp);
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
