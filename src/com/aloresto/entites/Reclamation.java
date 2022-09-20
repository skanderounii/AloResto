
package com.aloresto.entites;


public class Reclamation {
    
private int ref_rec;
private String description;
private String date_rec;
private float heure_rec;

    public Reclamation() {
    }

    public Reclamation(int ref_rec, String description, String date_rec, float heure_rec) {
        this.ref_rec = ref_rec;
        this.description = description;
        this.date_rec = date_rec;
        this.heure_rec = heure_rec;
    }

    public Reclamation(String description, String date_rec, float heure_rec) {
        this.description = description;
        this.date_rec = date_rec;
        this.heure_rec = heure_rec;
    }

    public Reclamation(int ref_rec) {
        this.ref_rec = ref_rec;
    }
    
    

    public int getRef_rec() {
        return ref_rec;
    }

    public String getDescription() {
        return description;
    }

    public String getDate_rec() {
        return date_rec;
    }

    public float getHeure_rec() {
        return heure_rec;
    }

    public void setRef_rec(int ref_rec) {
        this.ref_rec = ref_rec;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_rec(String date_rec) {
        this.date_rec = date_rec;
    }

    public void setHeure_rec(float heure_rec) {
        this.heure_rec = heure_rec;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "ref_rec=" + ref_rec + ", description=" + description + ", date_rec=" + date_rec + ", heure_rec=" + heure_rec + '}';
    }



    
}
