package entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author tekeu
 */
public class Agenda {

    private int idtache;
    private String titre;
    private String description;
    private String lieu;
    private java.sql.Date dat;
    private String heure;

    public Agenda(int idtache,  String titre, String description, String lieu, java.sql.Date dat, String heure) {
        this.idtache = idtache;
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.dat = dat;
        this.heure = heure;
    }

    public Agenda(String titre, String description, String lieu, java.sql.Date dat, String heure) {
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.dat = dat;
        this.heure = heure;
    }



    public int getIdtache() {
        return idtache;
    }

    public void setIdtache(int idtache) {
        this.idtache = idtache;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = new java.sql.Date(new Date().getTime());
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "Agenda{" + "idtache=" + idtache + ", titre=" + titre + ", description=" + description + ", lieu=" + lieu + ", dat=" + dat + ", heure=" + heure + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Agenda other = (Agenda) obj;
        if (this.idtache != other.idtache) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.heure, other.heure)) {
            return false;
        }
        return Objects.equals(this.dat, other.dat);
    }

    
    
    
}
