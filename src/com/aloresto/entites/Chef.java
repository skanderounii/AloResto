
package com.aloresto.entites;

public class Chef extends User {

private int ref_chef ;
private String specialite ;

    public Chef() {
    }

    public Chef(int ref_chef, String nom, String prenom, int tel, String adresse, String specialite) {
        super(nom, prenom, tel, adresse);
        this.ref_chef = ref_chef;
        this.specialite=specialite;
    }
    
     public Chef(String nom, String prenom, int tel, String adresse, String specialite) {
        super(nom, prenom, tel, adresse);
        this.specialite=specialite;
        
    }

    public Chef(int ref_chef) {
        this.ref_chef = ref_chef;
    }
     
     

    public int getRef_chef() {
        return ref_chef;
    }

    public void setRef_chef(int ref_chef) {
        this.ref_chef = ref_chef;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

   

   

    

  

    @Override
    public String toString() {
        return "Chef{" + "ref_chef=" + ref_chef  + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse + ", specialite=" + specialite + '}';
    }



    
}