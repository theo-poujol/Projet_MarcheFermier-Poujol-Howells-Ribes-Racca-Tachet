package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;


public class OrdreTrader extends Ordre{

    private double maximumUnitPrice;

    /**
     * Constructeur OrdreTrader.
     *
     * @param productName
     * @param amount
     * @param orderer
     * @param maximumUnitPrice
     */
    public OrdreTrader(String productName, int amount, Acheteur orderer, double maximumUnitPrice) {
        super(productName, amount, orderer);
        this.maximumUnitPrice = maximumUnitPrice;
    }

    /**
     * Getter qui retourne le prix maximun par unités.
     *
     * @return getMaximumUnitPrice
     */
    public double getMaximumUnitPrice() {
        return maximumUnitPrice;
    }
}
