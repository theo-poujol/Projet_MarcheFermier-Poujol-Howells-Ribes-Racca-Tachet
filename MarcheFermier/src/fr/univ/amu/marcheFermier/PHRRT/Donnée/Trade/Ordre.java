package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

/**
 * Created by Dorianosaure on 04/01/2019.
 */
public class Ordre {
    private String productName;
    private int amount;
    private Acheteur orderer;

    public Ordre(String productName, int amount, Acheteur orderer) {
        this.productName = productName;
        this.amount = amount;
        this.orderer = orderer;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    public Acheteur getOrderer() {
        return orderer;
    }
}
