package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughtMoneyException;

import java.util.ArrayList;
import java.util.HashMap;

public class Trader {
    //Un trader aura plusieurs traders avec un budget pour chacun
    private HashMap<Acheteur,Double> ListeDeMesClients = new HashMap<>();
    private String nom;
    private Double argentTrader;

    public Trader(String nom) {
        this.nom = nom;
    }

    public void nouveauClient(Acheteur acheteur, Double budget){
        try {
            acheteur.retirerArgent(budget);
            ListeDeMesClients.put(acheteur,budget*0.9); //l'acheteur est ajouté aux clients du trader
            argentTrader -= (budget-(budget*0.9)); //le solde personnel du trader est crédité de la commission de 10 pourcents
            System.out.println("Il vous reste " + acheteur.getMoney() +" € sur votre compte");
            System.out.println("/n Le trader "+ this.nom + " est heureux de vous coompter parmis ses clients désormais");
        } catch (NotEnoughtMoneyException e) {
            e.printStackTrace();
        }
    }

    public void mesClients(){
        ListeDeMesClients.forEach((acheteur, budget) ->{
            System.out.println(acheteur.getPseudo() + " avec un budget de " + budget + "€");
        } );
    }
}
