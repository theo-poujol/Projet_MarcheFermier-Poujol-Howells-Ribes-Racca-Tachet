package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Apiculteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Fromager;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.ProducteurDeViande;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Trader;

import java.util.ArrayList;
import java.util.List;


public class MarcheFermier {


    /**
     * lance tout le processus de simulation
     *
     * @param args
     */
    public static void main (String[] args){

        Producteur producteur = new ProducteurDeViande(new Apiculteur(new Fromager(new Producteur(500.00,"Sam"))));

        Acheteur loris = new Acheteur(20,"Lorisou");
        Acheteur albert = new Acheteur(30000, "Alberto30");

        List<Acheteur> participants = new ArrayList<>();
        participants.add(producteur);
        participants.add(loris);
        participants.add(albert);


        Marche marche = new Marche("Loris",5);
        marche.setParticipants(participants);

        Trader trader = new Trader(marche,"Vero");
        trader.addClient(loris);
        trader.addClient(albert);
        trader.addClient(producteur);

        Trader trader2 = new Trader(marche,"Nathalie");
        trader2.addClient(loris);
        trader2.addClient(albert);

        marche.addTrader(trader);
        marche.addTrader(trader2);

        marche.start();

    }
}
