package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste.Grossiste;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.*;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.*;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Trader;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughtMoneyException;

import java.time.LocalDate;


public class MarcheFermier {



    public static void main (String[] args) {
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

        Marche lesHalles = new Marche("Provence");
        System.out.println(lesHalles.getRegion());



        Grossiste grossiste = new Grossiste(1000000000,"Luca");
        Grossiste grossiste1 = new Grossiste(1000,"Charles");



        Miel monMiel = new Miel(LocalDate.now(),10,grossiste);
        Reblochon reblochon = new Reblochon(LocalDate.now(),20,grossiste);
        Pomme pomme = new Pomme(LocalDate.now(),160,grossiste);


        ViandeDeBoeuf viandeDeBoeuf = new ViandeDeBoeuf(LocalDate.now(), 20, grossiste1);
        Tomate tomate = new Tomate(LocalDate.now(),400,grossiste1);
        Miel mielCharles = new Miel(LocalDate.now(),5,grossiste1);


        grossiste.addToMyList(reblochon);
        grossiste.addToMyList(monMiel);
        grossiste.addToMyList(pomme);


        grossiste1.addToMyList(viandeDeBoeuf);
        grossiste1.addToMyList(tomate);
        grossiste1.addToMyList(mielCharles);

        System.out.println('\n' + "Luca");
        grossiste.showMyInformation();


        System.out.println('\n' + "Charles");
        grossiste1.showMyInformation();

        grossiste.sellMyProduct(lesHalles,reblochon,2,1);
        grossiste.sellMyProduct(lesHalles,pomme,0.50,123);
        grossiste.sellMyProduct(lesHalles,monMiel,2.5,2);


        grossiste1.sellMyProduct(lesHalles, viandeDeBoeuf, 5,10);
        grossiste1.sellMyProduct(lesHalles,tomate,0.50,200);
        grossiste1.sellMyProduct(lesHalles,mielCharles,3,2);

        System.out.println('\n' + "Luca");
        grossiste.showMyInformation();

        System.out.println('\n' + "Charles");
        grossiste1.showMyInformation();

        lesHalles.mesPropositionsVentes();


        System.out.println("\n" + "-------- PARTIE BUY ---------" + "\n");

        grossiste1.buyProduct(lesHalles,"Pomme",10,grossiste);


        System.out.println("\n "+ "----apres achat------" + "\n");

        lesHalles.mesPropositionsVentes();

        System.out.println("\n "+ "Luca");
        grossiste.showMyInformation();

        System.out.println("\n "+ "Charles");
        grossiste1.showMyInformation();



    }



}
