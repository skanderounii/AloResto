
package com.aloresto.entites;

public class Lignecommande {
  
private Commande ref_com;
private Plat ref_plat;
private String quantite;

    public Lignecommande() {
    }

    public Lignecommande(Commande ref_com, Plat ref_plat, String quantite) {
        this.ref_com = ref_com;
        this.ref_plat = ref_plat;
        this.quantite = quantite;
    }
    
    

    public Lignecommande(Plat ref_plat, String quantite) {
        this.ref_plat = ref_plat;
        this.quantite = quantite;
    }
     
    
    public Lignecommande(String quantite) {
        this.quantite = quantite;
    }

    public Lignecommande(Commande ref_com) {
        this.ref_com = ref_com;
    }
    
    
    
    

    public Commande getRef_com() {
        return ref_com;
    }

    public Plat getRef_plat() {
        return ref_plat;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setRef_com(Commande ref_com) {
        this.ref_com = ref_com;
    }

    public void setRef_plat(Plat ref_plat) {
        this.ref_plat = ref_plat;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Lignecommande{" + "ref_com=" + ref_com + ", ref_plat=" + ref_plat + ", quantite=" + quantite + '}';
    }





}
