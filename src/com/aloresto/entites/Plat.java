
package com.aloresto.entites;

public class Plat {
    
private int ref_plat;
private String nom_plat;
private String description_plat;
private float prix_plat;
private int temps_pre;

    public Plat() {
    }

    public Plat(int ref_plat) {
        this.ref_plat = ref_plat;
    }

    public Plat(int ref_plat, String nom_plat, String description_plat, float prix_plat, int temps_pre) {
        this.ref_plat = ref_plat;
        this.nom_plat = nom_plat;
        this.description_plat = description_plat;
        this.prix_plat = prix_plat;
        this.temps_pre = temps_pre;
    }

    public Plat(String nom_plat, String description_plat, float prix_plat, int temps_pre) {
        this.nom_plat = nom_plat;
        this.description_plat = description_plat;
        this.prix_plat = prix_plat;
        this.temps_pre = temps_pre;
    }

    public Plat(String nom_plat, float prix_plat, int temps_pre) {
        this.nom_plat = nom_plat;
        this.prix_plat = prix_plat;
        this.temps_pre = temps_pre;
    }
    
    

    public int getRef_plat() {
        return ref_plat;
    }

    public String getNom_plat() {
        return nom_plat;
    }

    public String getDescription_plat() {
        return description_plat;
    }

    public float getPrix_plat() {
        return prix_plat;
    }

    public int getTemps_pre() {
        return temps_pre;
    }

    public void setRef_plat(int ref_plat) {
        this.ref_plat = ref_plat;
    }

    public void setNom_plat(String nom_plat) {
        this.nom_plat = nom_plat;
    }

    public void setDescription_plat(String description_plat) {
        this.description_plat = description_plat;
    }

    public void setPrix_plat(float prix_plat) {
        this.prix_plat = prix_plat;
    }

    public void setTemps_pre(int temps_pre) {
        this.temps_pre = temps_pre;
    }

    @Override
    public String toString() {
        return "Plat{" + "ref_plat=" + ref_plat + ", nom_plat=" + nom_plat + ", description_plat=" + description_plat + ", prix_plat=" + prix_plat + ", temps_pre=" + temps_pre + '}';
    }



    
}
