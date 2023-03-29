package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tekeu
 */
public class Database {
     private String driver;
     private String dsn;
     private String username;
     private String password;
     
     public Database(){
          ///d'avoir le pilote permettant de manager le SGBD
          this.driver="com.mysql.cj.jdbc.Driver";
          this.dsn="jdbc:mysql://localhost:3306/agendajava";
          this.username="root";
          this.password="";
      }
      public Connection chaineConnexion(){
          try{
              Class.forName(this.driver);
              System.out.println("pilote trouve");
              return DriverManager.getConnection(this.dsn,this.username,this.password);
              
             }
          catch(Exception ex){
              System.out.println("ERREUR DE CONNEXION:" + ex.getMessage());
          }
          return null;
      }
        public static void main(String[] args){
          Database db=new Database();
          
          db.chaineConnexion();
          
      }
    
}
