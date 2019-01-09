package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

public class Ordre {
    private String productName;
    private int amount;
    private Acheteur orderer;

    /**
     * Constructeur Ordre.
     *
     * @param productName
     * @param amount
     * @param orderer
     */
    public Ordre(String productName, int amount, Acheteur orderer) {
        this.productName = productName;
        this.amount = amount;
        this.orderer = orderer;
    }

    /**
     *  Getter qui retourne le nom du produit.
     *
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Getter qui retourne le montant de produit commandé.
     *
     * @return getAmount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Getter retourne la commande.
     *
     * @return getOrderer
     */
    public Acheteur getOrderer() {
        return orderer;
    }
}
