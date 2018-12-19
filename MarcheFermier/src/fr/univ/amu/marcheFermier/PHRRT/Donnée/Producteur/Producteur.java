package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;

import java.util.ArrayList;
import java.util.List;

public class Producteur extends Acheteur {

    private boolean bio = false;
    private List<ProduitFermier> stock = new ArrayList<>();
    private int capacite = 50;

    public Producteur(double money, String pseudo) {
        super(money, pseudo);
    }

    public  List<ProduitFermier> getStock() {
        return stock;
    }


    public void produire() {

    }

    public void addProduit(ProduitFermier produitFermier) throws NotEnoughCapacityException {
        /*
        //Check capacite
        int capaciteRestante = capacite - getCurrentCapacite();

        //si il n'y a plus de place on n'ajoute pas
        if (capaciteRestante == 0) return;
        //si le produit est deja en possession du producteur

        if (!addExistingProduit(produitFermier)) {
            //si le montant produit est superieur a la capacite disponible
            if (produitFermier.getAmount() > capaciteRestante) {
                //on calcul le nombre de produit détruit par l'operation
                int deletedAmount = produitFermier.getAmount() - capaciteRestante;
                //on remplace le montant de produit par un montant qui rentre dans la capacite du producteur
                produitFermier.setAmount(capaciteRestante);
                //on leve une exception comme quoi des produits ont été perdus pour manque de place
                throw new NotEnoughCapacityException(produitFermier,deletedAmount);
            }
            stock.add(produitFermier);
        }*/

        stock.add(produitFermier);
    }

    private int getCurrentCapacite() {
        int currentCapacite = 0;
        for (ProduitFermier produitFermier : stock) {
            currentCapacite += produitFermier.getAmount();
        }
        return currentCapacite;
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


}
