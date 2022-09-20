/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aloresto.entites;

/**
 *
 * @author Chaouki-NH
 */
public class User {
protected int id;
protected int tel;
protected String nom ;
protected String prenom ;
protected String adresse ;


    public User() {
    }
    
     public User(int id, String nom, String prenom, int tel, String adresse) {
       
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
    }
     
     public User(String nom, String prenom, int tel, String adresse) {
       
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
    }

    public User(int id) {
        this.id = id;
    }
     
    

   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", tel=" + tel + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + '}';
    }

  
    
 

}




