
package com.aloresto.entites;


public class Etat {
    
private int ref_etat;
private String type_etat;

    public Etat() {
    }

    public Etat(int ref_etat, String type_etat) {
        this.ref_etat = ref_etat;
        this.type_etat = type_etat;
    }

    public Etat(int ref_etat) {
        this.ref_etat = ref_etat;
    }

    public Etat(String type_etat) {
        this.type_etat = type_etat;
    }

    public int getRef_etat() {
        return ref_etat;
    }

    public String getType_etat() {
        return type_etat;
    }

    public void setRef_etat(int ref_etat) {
        this.ref_etat = ref_etat;
    }

    public void setType_etat(String type_etat) {
        this.type_etat = type_etat;
    }

    @Override
    public String toString() {
        return "Etat{" + "ref_etat=" + ref_etat + ", type_etat=" + type_etat + '}';
    }


    
}
