
package com.aloresto.entites;


public class Livraison {
    
private int ref_liv;
private String date_liv;
private float heure_liv;

    public Livraison() {
    }

    public Livraison(int ref_liv, String date_liv, float heure_liv) {
        this.ref_liv = ref_liv;
        this.date_liv = date_liv;
        this.heure_liv = heure_liv;
    }

    public Livraison(String date_liv, float heure_liv) {
        this.date_liv = date_liv;
        this.heure_liv = heure_liv;
    }

    public Livraison(int ref_liv) {
        this.ref_liv = ref_liv;
    }

    public int getRef_liv() {
        return ref_liv;
    }

    public String getDate_liv() {
        return date_liv;
    }

    public float getHeure_liv() {
        return heure_liv;
    }

    public void setRef_liv(int ref_liv) {
        this.ref_liv = ref_liv;
    }

    public void setDate_liv(String date_liv) {
        this.date_liv = date_liv;
    }

    public void setHeure_liv(float heure_liv) {
        this.heure_liv = heure_liv;
    }

    @Override
    public String toString() {
        return "Livraison{" + "ref_liv=" + ref_liv + ", date_liv=" + date_liv + ", heure_liv=" + heure_liv + '}';
    }


    
}
