
package com.aloresto.entites;

public class Client extends User {

private int ref_client;

    public Client() {
    }

    public Client(int ref_client, String nom, String prenom, int tel, String adresse) {
        super(nom, prenom, tel, adresse);
        this.ref_client = ref_client;
    }
    
     public Client(String nom, String prenom, int tel, String adresse) {
        super(nom, prenom, tel, adresse);
        
    }

    public Client(int ref_client) {
        this.ref_client = ref_client;
    }
     
     

    public int getRef_client() {
        return ref_client;
    }

    public void setRef_client(int ref_client) {
        this.ref_client = ref_client;
    }

    

  

    @Override
    public String toString() {
        return "Client{" + "ref_client=" + ref_client  + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse + '}';
    }



    
}
