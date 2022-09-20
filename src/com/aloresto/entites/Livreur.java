
package com.aloresto.entites;

public class Livreur extends User {

private int ref_livreur;
private String zone;

    public Livreur() {
    }

    public Livreur(int ref_livreur, String nom, String prenom, int tel, String adresse, String zone) {
        super(nom, prenom, tel, adresse);
        this.ref_livreur = ref_livreur;
        this.zone=zone;
    }
    
     public Livreur(String nom, String prenom, int tel, String adresse, String zone) {
        super(nom, prenom, tel, adresse);
        this.zone=zone;
        
    }

    public Livreur(int ref_livreur) {
        this.ref_livreur = ref_livreur;
    }
     

    public int getRef_livreur() {
        return ref_livreur;
    }

    public void setRef_livreur(int ref_livreur) {
        this.ref_livreur = ref_livreur;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

   

    

  

    @Override
    public String toString() {
        return "Client{" + "ref_client=" + ref_livreur  + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse + ", zone=" + zone + '}';
    }



    
}