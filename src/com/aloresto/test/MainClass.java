/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aloresto.test;
import com.aloresto.entites.Admin;
import com.aloresto.entites.Categories;
import com.aloresto.entites.User;
import com.aloresto.entites.Client;
import com.aloresto.entites.Livreur;
import com.aloresto.entites.Chef;
import com.aloresto.entites.Commande;
import com.aloresto.entites.Etat;
import com.aloresto.entites.Lignecommande;
import com.aloresto.entites.Livraison;
import com.aloresto.entites.Plat;
import com.aloresto.entites.Reclamation;
import com.aloresto.entites.Route;

import com.aloresto.services.UserService;
import com.aloresto.services.AdminService;
import com.aloresto.services.CategoriesService;
import com.aloresto.services.ClientService;
import com.aloresto.services.LivreurService;
import com.aloresto.services.ChefService;
import com.aloresto.services.CommandeService;
import com.aloresto.services.EtatService;
import com.aloresto.services.LignecommandeService;
import com.aloresto.services.LivraisonService;
import com.aloresto.services.PlatService;
import com.aloresto.services.ReclamationService;
import com.aloresto.services.RouteService;

import com.aloresto.utils.MaConnexion;
import java.sql.SQLException;



/**
 *
 * @author FGH
 */
public class MainClass {
    
    public static void main(String[] args) {
        
         
          MaConnexion cn1 = MaConnexion.getInstance();
//        MaConnexion cn2 = MaConnexion.getInstance();
//        MaConnexion cn3 = MaConnexion.getInstance();
//        MaConnexion cn4 = MaConnexion.getInstance();
//        
//        System.out.println(cn1.hashCode());
//        System.out.println(cn2.hashCode());
//        System.out.println(cn3.hashCode());
//        System.out.println(cn4.hashCode());


        UserService us = new UserService();
        ClientService cl = new ClientService();
        AdminService ad = new AdminService();
        LivreurService li = new LivreurService();
        ChefService ch = new ChefService();
        
        CommandeService co = new CommandeService();
        LignecommandeService lc = new LignecommandeService();
        PlatService pl = new PlatService();
        CategoriesService ca = new CategoriesService();
        
        EtatService et = new EtatService();
        ReclamationService re = new ReclamationService();
        LivraisonService lv = new LivraisonService();
        RouteService ro = new RouteService();
        
        
        
        
        
        User u = new User("hanenbb", "siwar", 27963123 , "tunis");
        Client c = new Client(92, "hani", "hani", 55963123 , "tunis");
        Admin a = new Admin(4, "ahmed", "nasri", 27963123 , "tunis");
        Livreur l = new Livreur(1, "imen", "nasri", 98963123 , "tunis", "zonehh");
        Chef cc = new Chef(1, "ahlem", "nasri", 22963123 , "gabes", "fruit");
        
        Commande cm = new Commande(1,"12");
        Lignecommande lg = new Lignecommande("320kg");
        Plat pa = new Plat("sandwtch",9.2f,20);
        Categories ct = new Categories(1);
        
        Etat ea = new Etat(2,"parfait");
        Reclamation rc = new Reclamation(2,"dddd","01/4/2022",15.30f);
        Livraison lr = new Livraison(2);
        Route rt = new Route(2);
        
        
        
       
        try {
        //ro.ajouter(rt);
         //ro.modifier(rt);
        ro.supprimer(rt);
            //System.out.println(re.afficher());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        
    }
}
       
     
        
    