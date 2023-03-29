package model;

import entity.Compte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CompteModel {
    private Database db;
    
    public CompteModel(){
        this.db = new Database();
    }
    public void create(Compte p){
        System.out.println("test");
        try{
            Connection con = this.db.chaineConnexion();
            String sql="INSERT INTO compte SET  nom=?,email=?,datenaiss=?,mdp=?,phrasec=?,reponse=?";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, p.getNom());
            req.setObject(2, p.getEmail());
            req.setObject(3, p.getDatenaiss());
            req.setObject(4, p.getMdp());
            req.setObject(5, p.getPhasec());
            req.setObject(6, p.getReponse());
            req.execute();
            con.close();
             JOptionPane.showMessageDialog(null, "compte ajouter avec success","Info",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "echec de l'enregistrement car" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public Compte read(int idtache){
        Compte p =null;
        try{
            Connection con = this.db.chaineConnexion();
            String sql="SELECT * FROM Compte WHERE idcompte='"+idtache+"'";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, idtache);
            ResultSet rs=req.executeQuery();
            rs.next(); //on se place sur la ligne de la bd a recuperer
            con.close();
            p = new Compte(
            rs.getString("nom"),
            rs.getString("email"), 
            rs.getDate("dat"),
            rs.getString("mdp"), 
            rs.getString("phasec"),
            rs.getString("reponse")
            );
            con.close();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Compte ajouter avec success" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
       return p; 
    }
       public Compte readCompte(int idCompte){
        Compte p=null;
        try{
            Connection con = this.db.chaineConnexion();
            String sql="SELECT * FROM Compte WHERE idCompte=?";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, idCompte);
            ResultSet rs = req.executeQuery();
            rs.next();//on se place sur la ligne de la bd a recuperer
            con.close();
            p = new Compte(
            rs.getString("nom"),
            rs.getString("email"), 
            rs.getDate("dat"),
            rs.getString("mdp"), 
            rs.getString("phasec"),
            rs.getString("reponse")
            );
            con.close();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "les Comptes ne peuvent ètre afficher car " + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
       return p; 
    }
    public ArrayList<Compte> readAll(){
        ArrayList<Compte> Comptes=null;
        Compte p=null;
        try{
            Connection con = this.db.chaineConnexion();
            String sql="SELECT * FROM Compte order by idcompte desc";
            PreparedStatement req= con.prepareStatement(sql);
            ResultSet rs=req.executeQuery();
            
           Comptes =new  ArrayList<Compte>();//on recupere plusieurs informations(plusieurs Compte) que l'on stocke desArrayList<Comptes>
            while(rs.next()){
            p = new Compte(
            rs.getString("nom"),
            rs.getString("email"), 
            rs.getDate("dat"),        
            rs.getString("mdp"), 
            rs.getString("phasec"),
            rs.getString("reponse")
            );
               Comptes.add(p);
            }
            
            con.close();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "les Comptes ne peuvent etre afficher car " + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
       return Comptes; 
    }
    public void update(Compte p){
        try{
            Connection con = this.db.chaineConnexion();
            String sql="INSERT INTO compte SET nom=?,email=?,datenaiss=?,mdp=?,phrasec=?,reponse=? WHERE idcompte=?";
            PreparedStatement req= con.prepareStatement(sql);
           req.setObject(1, p.getNom());
            req.setObject(2, p.getEmail());
            req.setObject(3, p.getDatenaiss());
            req.setObject(4, p.getMdp());
            req.setObject(5, p.getPhasec());
            req.setObject(5, p.getReponse());
            req.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "compte modifier avec success","Info",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ereur" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(int idcompte){
        try{
            Connection con = this.db.chaineConnexion();
            String sql="DELETE FROM compte WHERE idcompte=?";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, idcompte);
            req.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "compte suprimer  avec success","Info",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ereur" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
   
    
    
}

