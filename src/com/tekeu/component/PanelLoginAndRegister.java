package com.tekeu.component;


import com.tekeu.swing.Button;
import com.tekeu.swing.MyPasswordField;
import com.tekeu.swing.MyTextField;
import com.raven.main.Main;
import com.raven.component.Header;
import com.raven.form.Form_Home;
import entity.Compte;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.CompteModel;
import model.Database;
import net.miginfocom.swing.MigLayout;


public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
    
    private final CompteModel comptedb = new CompteModel();
    private Compte cmp = null;
    private Form_Home in = new Form_Home();
    private Header d = new Header();
    Database db = new Database();
    int nbre=0;
    

    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }
    


    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Créer un compte");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tekeu/icon/user.png")));
        txtUser.setHint("Nom");
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
                 comptedb.create(cmp);
                 Main obj = new Main();
                 d.lbUserName.setText(nom1);
                 in.Username.setText(nom1);
                 obj.show();
                 System.out.println("le nom est :"+in.Username.getText());
            }
        
        });
         register.add(cmd, "w 40%, h 40");
         
    }
    public Compte compte(String mail, String passe){
            
    //selectionne nom et  password dans la db
                    try{
                        Connection connect = db.chaineConnexion();
                        String sql="select * from compte where nom=? and mdp=?";
                        PreparedStatement pst = connect.prepareStatement(sql);
                        pst.setObject(1,mail);
                        pst.setObject(2,passe);
                        ResultSet  rs =pst.executeQuery();
                        boolean userconnected = false;
                        while(rs.next()){
                            userconnected = true;
                            cmp = Compte.from(rs); 
                        nbre++;
                        }
                        int id = cmp.idCompte; 
                        System.out.println("l'id est :"+id);
                        connect.close();
                    }catch(SQLException ex){
                        ex.printStackTrace();
        }   
                    return cmp;
    }
    
    

    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Se Connectez");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tekeu/icon/user.png")));
        txtUser.setHint("Nom");
        login.add(txtUser, "w 60%");
        
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/tekeu/icon/pass.png")));
        txtPass.setHint("Mot de passe");
        login.add(txtPass, "w 60%");
        
        JButton cmdForget = new JButton("Mot de passe oublié?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("CONNEXION");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             String email = txtUser.getText();
             String pas = txtPass.getText();
             JFrame f=new JFrame();
             compte(email, pas);
                if(nbre<1){
                JOptionPane.showMessageDialog(f,"echec de connexion");
                }else{
                JOptionPane.showMessageDialog(f,"connexion reussie");
                Main obj =new Main();
                obj.setVisible(true);
                d.lbUserName.setText(email);
                in.Username.setText(email);
                obj.show();
                //System.out.println("l'id est :"+id);
                System.out.println("le nom est :"+in.Username.getText());
                }
            }
        
        });
        login.add(cmd, "w 40%, h 40");
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
