
package com.aloresto.entites;

public class Admin extends User {

private int ref_admin;

    public Admin() {
    }

    public Admin(int ref_admin, String nom, String prenom, int tel, String adresse) {
        super(nom, prenom, tel, adresse);
        this.ref_admin = ref_admin;
    }
    
     public Admin(String nom, String prenom, int tel, String adresse) {
        super(nom, prenom, tel, adresse);
        
    }

    public Admin(int ref_admin) {
        this.ref_admin = ref_admin;
    }
     
     

    public int getRef_admin() {
        return ref_admin;
    }

    public void setRef_admin(int ref_admin) {
        this.ref_admin = ref_admin;
    }

    @Override
    public String toString() {
        return "Admin{" + "ref_admin=" + ref_admin  + ", nom=" + nom + ", prenom=" + prenom  + ", tel=" + tel + ", adresse=" + adresse + '}';
    }

  

    



    
}