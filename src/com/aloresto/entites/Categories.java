
package com.aloresto.entites;


public class Categories {

private int ref_cat;
private String type_cat;
private String libelle;

    public Categories() {
    }

    public Categories(int ref_cat) {
        this.ref_cat = ref_cat;
    }

    public Categories(int ref_cat, String type_cat, String libelle) {
        this.ref_cat = ref_cat;
        this.type_cat = type_cat;
        this.libelle = libelle;
    }

    public Categories(String type_cat, String libelle) {
        this.type_cat = type_cat;
        this.libelle = libelle;
    }

    public int getRef_cat() {
        return ref_cat;
    }

    public String getType_cat() {
        return type_cat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setRef_cat(int ref_cat) {
        this.ref_cat = ref_cat;
    }

    public void setType_cat(String type_cat) {
        this.type_cat = type_cat;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categories{" + "ref_cat=" + ref_cat + ", type_cat=" + type_cat + ", libelle=" + libelle + '}';
    }



}
