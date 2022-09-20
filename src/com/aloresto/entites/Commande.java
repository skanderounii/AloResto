
package com.aloresto.entites;


public class Commande {

private int ref_com;
private String date_com;

    public Commande() {
    }

    public Commande(int ref_com, String date_com) {
        this.ref_com = ref_com;
        this.date_com = date_com;
    }

    public Commande(int ref_com) {
        this.ref_com = ref_com;
    }
    
    

    public Commande(String date_com) {
        this.date_com = date_com;
    }

    public int getRef_com() {
        return ref_com;
    }

    public String getDate_com() {
        return date_com;
    }

    public void setRef_com(int ref_com) {
        this.ref_com = ref_com;
    }

    public void setDate_com(String date_com) {
        this.date_com = date_com;
    }

    @Override
    public String toString() {
        return "Commande{" + "ref_com=" + ref_com + ", date_com=" + date_com + '}';
    }



}
