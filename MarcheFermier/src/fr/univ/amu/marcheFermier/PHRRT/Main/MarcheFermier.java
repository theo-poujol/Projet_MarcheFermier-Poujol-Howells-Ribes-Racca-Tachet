package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Apiculteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.ProducteurDeViande;


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

        Producteur producteur = new Apiculteur(new ProducteurDeViande(new Producteur()));
        producteur.produire();



    }


    public void loadMarketListing() {

    }
}
