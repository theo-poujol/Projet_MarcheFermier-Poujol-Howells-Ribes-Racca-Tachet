package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

/**
 * Created by Dorianosaure on 04/01/2019.
 */
public class OrdreTrader extends Ordre{

    private double maximumUnitPrice;

    public OrdreTrader(String productName, int amount, Acheteur orderer, double maximumUnitPrice) {
        super(productName, amount, orderer);
        this.maximumUnitPrice = maximumUnitPrice;
    }

    public double getMaximumUnitPrice() {
        return maximumUnitPrice;
    }
}
