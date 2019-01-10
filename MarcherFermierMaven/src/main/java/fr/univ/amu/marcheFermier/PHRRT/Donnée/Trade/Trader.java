package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;
import fr.univ.amu.marcheFermier.PHRRT.Main.Marche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trader {
    private String name;
    private List<Acheteur> clients = new ArrayList<>();
    private List<OrdreTrader> ordres = new ArrayList<>();
    private Marche marche;

    /**
     * Constructeur Trader.
     *
     * @param marche
     */
    public Trader(Marche marche, String name) {
        this.name = name;
        this.marche = marche;
    }

    /**
     * Permet d'ajouter des commandes au trader.
     *
     * @param ordreTrader
     */
    public void addOrder(OrdreTrader ordreTrader) {
        ordres.add(ordreTrader);
    }

    /**
     * Achete le produit au prix demandé.
     *
     * @throws NotEnoughMoneyException
     *          verifie que le client a l'argent nécessaire pour acheter le produit.
     */
    public void checkMarket() throws NotEnoughMoneyException {
        List<ProduitFermier> productSellCopy = new ArrayList<>();
        productSellCopy.addAll(marche.getProductSell());
        for (ProduitFermier produitFermier : productSellCopy) {
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

    /**
     * setter client
     * @param acheteur
     */
    public void addClient(Acheteur acheteur) {
        clients.add(acheteur);
    }

    /**
     * getter nom
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter nombre clients du trader
     * @return clients.size()
     */
    public int getClientNumber() {
        return clients.size();
    }

    /**
     * getter liste clients
     * @return clients
     */
    public List<Acheteur> getClients() {
        return clients;
    }

    /**
     * getter ordres
     * @return ordres
     */
    public List<OrdreTrader> getOrdres() {
        return ordres;
    }
}
