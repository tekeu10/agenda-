package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author tekeu
 */
public class Compte {
    public int idCompte;
    private String nom;
    private String email;
    private Date datenaiss;
    private String mdp;
    private String phasec;
    private String reponse;

    public Compte(int idCompte, String nom, String mdp) {
        this.idCompte = idCompte;
        this.nom = nom;
        this.mdp = mdp;
    }

    public Compte() {
        this.idCompte = 0;
        this.nom = null;
        this.email = null;
        this.datenaiss = null;
        this.mdp = null;
        this.phasec = null;
        this.reponse = null;
    }
    
    

    public Compte(int idCompte, String nom, String email, Date datenaiss, String mdp, String phasec, String reponse) {
        this.idCompte = idCompte;
        this.nom = nom;
        this.email = email;
        this.datenaiss = datenaiss;
        this.mdp = mdp;
        this.phasec = phasec;
        this.reponse = reponse;
    }

    public Compte(String nom, String email, Date datenaiss, String mdp, String phasec, String reponse) {
        this.nom = nom;
        this.email = email;
        this.datenaiss = datenaiss;
        this.mdp = mdp;
        this.phasec = phasec;
        this.reponse = reponse;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPhasec() {
        return phasec;
    }

    public void setPhasec(String phasec) {
        this.phasec = phasec;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    /**
     *
     * @param result
     * @return
     */
    public static Compte from(ResultSet result) throws SQLException{
        return new Compte(result.getInt(1), result.getString(2), result.getString(4));
    }
    
    @Override
    public String toString() {
        return "Compte{" + "idCompte=" + idCompte + ", nom=" + nom + ", email=" + email + ", datenaiss=" + datenaiss + ", mdp=" + mdp + ", phasec=" + phasec + ", reponse=" + reponse + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compte other = (Compte) obj;
        if (this.idCompte != other.idCompte) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        if (!Objects.equals(this.phasec, other.phasec)) {
            return false;
        }
        if (!Objects.equals(this.reponse, other.reponse)) {
            return false;
        }
        return Objects.equals(this.datenaiss, other.datenaiss);
    }
   
}
