package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Apiculteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Fromager;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.ProducteurDeViande;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Miel;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitLaitier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Menu;


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
        System.out.println(ahcteurururuu.getArgent());
        System.out.println(ahcteurururuu.getPseudo());
        Trader traderssss = new Trader("LoupDeWallStreet");
        traderssss.nouveauClient(ahcteurururuu,5000.0);
        traderssss.mesClients();
        */
        Producteur producteur = new ProducteurDeViande(new Apiculteur(new Fromager(new Producteur(500.00,"Sam"))));
        producteur.setBio(true);
        producteur.produire();





        System.out.println(producteur.getStock());
        System.out.println("debut");
        for (ProduitFermier currentProduitFermier : producteur.getStock()) {
            System.out.println("il y a " + currentProduitFermier.getAmount() + " unités du produit : " + currentProduitFermier.getName());
            if (currentProduitFermier.isBio()) {
                System.out.println("je suis bio");
            }
        }
        System.out.println("fini");
    }
}
