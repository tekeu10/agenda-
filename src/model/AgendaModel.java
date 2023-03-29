package model;

import entity.Agenda;
import entity.Compte;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author tekeu
 */

public class AgendaModel {
     private Database db;
     private Compte cp;
    
    public AgendaModel(){
        this.db=new Database();
    }
    public void create(Agenda p){
        try{
            Connection con = this.db.chaineConnexion();
            String sql="INSERT INTO tache SET titre=?,description=?,date=?,jour=?,mois=?,année=?";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, p.getTitre());
            req.setObject(2, p.getDescription());
            req.setObject(3, p.getLieu());
            req.setObject(4, p.getDat());
            req.setObject(5, p.getHeure());
            req.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "evenement ajouter avec success","Info",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "echec de l'enregistrement " + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public Agenda read(int idtache){
        Agenda p =null;
        try{
            Connection con = this.db.chaineConnexion();
            String sql="SELECT * FROM tache WHERE idtache=?";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, idtache);
            ResultSet rs=req.executeQuery();
            rs.next(); //on se place sur la ligne de la bd a recuperer
            con.close();
            p = new Agenda(
            rs.getInt("id"),
            rs.getString("titre"),
            rs.getString("description"),         
            rs.getString("lieu"),
            rs.getDate("date"), 
            rs.getString("heure")
            );
            con.close();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "evenement ajouter avec success" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
       return p; 
    }
       public Agenda readIntitule(int description){
        Agenda p=null;
        try{
            Connection con = this.db.chaineConnexion();
            String sql="SELECT * FROM tache WHERE description=?";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, description);
            ResultSet rs=req.executeQuery();
            rs.next();//on se place sur la ligne de la bd a recuperer
            con.close();
             p = new Agenda(
            rs.getInt("idtache"),
            rs.getString("titre"),
            rs.getString("description"),
            rs.getString("lieu"),
            rs.getDate("Date"), 
            rs.getString("heure")
            );
            con.close();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "les évènements ne peuvent ètre ajouter car " + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
       return p; 
    }
    public ArrayList<Agenda> readAll(){
        ArrayList<Agenda> Agendas=null;
        Agenda p=null;
        try{
            Connection con = this.db.chaineConnexion();
            String sql="SELECT * FROM tache order by idtache desc";
            PreparedStatement req= con.prepareStatement(sql);
            ResultSet rs=req.executeQuery();
            
           Agendas =new  ArrayList<Agenda>();//on recupere plusieurs informations(plusieurs evenement) que l'on stocke desArrayList<Agenda>
            while(rs.next()){
               p = new Agenda(
            rs.getInt("idtache"),
            rs.getString("titre"),
            rs.getString("description"),
            rs.getString("lieu"),
            rs.getDate("Date"), 
            rs.getString("heure")
            ); 
               Agendas.add(p);
            }
            
            con.close();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "les évènements ne peuvent etre afficher car " + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
       return Agendas; 
    } 
    public void update(Agenda p){
        try{
            Connection con = this.db.chaineConnexion();
            String sql="UPDATE FRO tache SET description=?,date=?,jour=?,mois=?,année=? WHERE idtache=?";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, p.getTitre());
            req.setObject(2, p.getDescription());
            req.setObject(3, p.getLieu());
            req.setObject(4, p.getDat());
            req.setObject(5, p.getHeure());
            req.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "evenement modifier avec success","Info",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ereur" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void delete(int idtache){
        try{
            Connection con = this.db.chaineConnexion();
            String sql="DELETE FROM tache WHERE idtache=?";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, idtache);
            req.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "evenement suprimer  avec success","Info",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ereur" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
   /* public void recherche(String titre){
        try{
            Connection con = this.db.chaineConnexion();
            String sql="SELECT * FROM tache WHERE titre='"+titre+"'";
            PreparedStatement req= con.prepareStatement(sql);
            req.setObject(1, titre);
            ResultSet rs=req.executeQuery();
            rs.last();
            int nbrrow = rs.getRow();
            if(nbrrow != 0){
                JOptionPane.showMessageDialog(null, "produit trouvé");
            }
            con.close();
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ereur" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }*/
    public  void rechercheauto(JTable jt, JTextField jtf, JLabel jl){
        DefaultTableModel dtm = (DefaultTableModel)jt.getModel();
         String mot = jtf.getText().trim();
         TableRowSorter <DefaultTableModel> trs = new TableRowSorter <>(dtm);
         jt.setRowSorter(trs);
         trs.setRowFilter(RowFilter.regexFilter(mot));
         int nbre = jt.getRowCount();
         if(nbre == 0){
             jl.setForeground(Color.red);
             jl.setText("aucun évènement trouvé ");
         }else if(nbre == 1){
             jl.setForeground(new Color(0,102,0));
             jl.setText("Un évènement trouvé ");
         }else if(nbre >= 1){
             jl.setForeground(new Color(0,102,0));
             jl.setText("retrouvé : "+nbre);
         }
    }
    
}
