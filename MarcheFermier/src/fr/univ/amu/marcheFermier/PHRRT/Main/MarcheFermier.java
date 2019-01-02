package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste.Grossiste;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.*;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.*;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Trader;

import java.time.LocalDate;


public class MarcheFermier {



    public static void main (String[] args){
        /*ProduitFermier produitFermier = new Miel(LocalDate.now(),200);

        System.out.println(produitFermier.getPeremptionDate());

        System.out.println(produitFermier.getLabels());

        Label label = new Label("Loris", "JE FAIS RIEN DEPUIS 1H30");

        produitFermier.addLabel(label);

        for (Label currentLabel : produitFermier.getLabels()) {
            System.out.println("Title " + label.getTitle());
            System.out.println("Desc : " + label.getDescription());
        }
        */

        // Producteur producteur = new Apiculteur(new ProducteurDeViande(new Producteur()));
        //producteur.produire();

        /*Acheteur ahcteurururuu = new Acheteur(4500.0,"Texal");
        System.out.println(ahcteurururuu.getMoney());
        System.out.println(ahcteurururuu.getPseudo());
        Trader traderssss = new Trader("LoupDeWallStreet");
        traderssss.nouveauClient(ahcteurururuu,4000.0);
        traderssss.mesClients();
        */



        Producteur producteur = new ProducteurDeViande(new Apiculteur(new Fromager(new Orticulteur(new Producteur(1900,"Loris")))));

        /*
        producteur.produire();

        System.out.println(producteur.getStock());
        System.out.println("debut");
        for (ProduitFermier currentProduitFermier : producteur.getStock()) {
            System.out.println("il y a " + currentProduitFermier.getAmount() + " unités du produit : " + currentProduitFermier.getName());
        }
        System.out.println("fini");
        */

        Marche LesHalles = new Marche();

        Grossiste grossiste = new Grossiste(1000000000,"Luca");

        Miel monMiel = new Miel(LocalDate.now(),10,grossiste);
        Reblochon reblochon = new Reblochon(LocalDate.now(),20,grossiste);
        Pomme pomme = new Pomme(LocalDate.now(),160,grossiste);


        grossiste.addToMyList(reblochon);
        grossiste.addToMyList(monMiel);
        grossiste.addToMyList(pomme);

        grossiste.showMyInformation();


        grossiste.sellMyProduct(reblochon,2,1);
        grossiste.sellMyProduct(pomme,0.50,123);
        grossiste.sellMyProduct(monMiel,2.5,2);

        grossiste.showMyInformation();


    }


    public void loadMarketListing() {

    }
}
