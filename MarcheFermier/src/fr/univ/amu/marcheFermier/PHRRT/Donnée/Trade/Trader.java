package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;

import java.util.HashMap;

public class Trader {
    //Un trader aura plusieurs traders avec un budget pour chacun
    private HashMap<Acheteur,Double> ListeDeMesClients = new HashMap<>();
    private String nom;
    private Double argentTrader = 0.0;

    public Trader(String nom) {
        this.nom = nom;
    }

    public Double getArgentTrader() {
        return argentTrader;
    }

/* crée un nouveau client, ajoute son budget moins une commision et donne la commission au trader*/
    public void nouveauClient(Acheteur acheteur, Double budget){
        try {
            acheteur.retirerArgent(budget);
            ListeDeMesClients.put(acheteur,budget*0.9); //l'acheteur est ajouté aux clients du trader
            argentTrader += (budget-(budget*0.9)); //le solde personnel du trader est crédité de la commission de 10 pourcents
            System.out.println("Il vous reste " + acheteur.getArgent() +" € sur votre compte");
            System.out.println(" Le trader "+ this.nom + " est heureux de vous coompter parmis ses clients désormais");
            System.out.println("Une taxe de 10% à été prélevée pour les honoraires du trader sois " + argentTrader + "€" );
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }
/*
renvoi une liste de client dans la console
avec indication du budget dont il dispose
*/
    public void mesClients(){
        ListeDeMesClients.forEach((acheteur, budget) ->{
            System.out.println(acheteur.getPseudo() + " avec un budget de " + budget + "€");
        } );
    }


    public void visiter(){
        //doit verifier les cotations et si intéréssantes il achete pour les clients

    }


}
