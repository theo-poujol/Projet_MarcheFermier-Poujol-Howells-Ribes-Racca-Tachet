package fr.univ.amu.marcheFermier.PHRRT.Donnée;


import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;

public class Acheteur {


    private List<ProduitFermier> stock = new ArrayList<>();
    private double argent;
    private String pseudo;

    public Acheteur(double argent, String pseudo) {
        this.argent = argent;
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }




    public  List<ProduitFermier> getStock() {
        return stock;
    }
    public double getArgent() {
        return argent;
    }
    public void retirerArgent(Double budget) throws NotEnoughMoneyException {
        argent -= budget;


    }
    public void ajouterArgent(Double budget) {
        argent += budget;
    }
    public void addProduit(ProduitFermier produitFermier) throws NotEnoughCapacityException {


        if (!addExistingProduit(produitFermier)) {
            stock.add(produitFermier);
        }
    }

    private boolean addExistingProduit(ProduitFermier produitFermier) {
        //si le produit est deja en possession du producteur
        for (ProduitFermier currentProduit : stock) {
            //si le nom du nouveau produit correspond au nom d'un produit du stock
            if (currentProduit.getName().equalsIgnoreCase(produitFermier.getName())) {
                //on change juste le montant
                int currentAmount = currentProduit.getAmount();
                currentProduit.setAmount(currentAmount + produitFermier.getAmount());
                return true;
            }
        }
        //si le produit n'existe pas dans le stock
        return false;
    }

    public void addArgent(double montant) {
        this.argent = argent + montant;
    }
}

