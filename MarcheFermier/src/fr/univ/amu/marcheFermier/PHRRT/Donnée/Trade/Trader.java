package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;
import fr.univ.amu.marcheFermier.PHRRT.Main.Marche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trader {
    private List<OrdreTrader> ordres = new ArrayList<>();
    private Marche marche;


    public Trader(Marche marche) {
        this.marche = marche;
    }

    public void addOrder(OrdreTrader ordreTrader) {
        ordres.add(ordreTrader);
    }

    public void checkMarket() throws NotEnoughMoneyException {
        for (ProduitFermier produitFermier : marche.getProductSell()) {
            for (OrdreTrader ordreTrader : ordres) {
                if (produitFermier.getName().equalsIgnoreCase(ordreTrader.getProductName())) {
                    double unitPrice = produitFermier.getPrix()/produitFermier.getAmount();
                    if (unitPrice <= ordreTrader.getMaximumUnitPrice()) {
                        marche.buy(ordreTrader.getOrderer(),marche.getProductSell().indexOf(produitFermier),ordreTrader.getAmount());
                    }
                }
            }
        }
    }
}
