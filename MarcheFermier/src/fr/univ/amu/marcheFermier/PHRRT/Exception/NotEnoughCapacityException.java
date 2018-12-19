package fr.univ.amu.marcheFermier.PHRRT.Exception;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;

public class NotEnoughCapacityException extends Exception {

    private ProduitFermier produitFermier;
    private int deletedAmount;

    public NotEnoughCapacityException(ProduitFermier produitFermier, int deletedAmount) {
        this.produitFermier = produitFermier;
        this.deletedAmount = deletedAmount;
    }

    @Override
    public String getMessage() {
        return deletedAmount + " unité(s) de " + produitFermier.getName()  + " ont été détruit par manque de capacité du producteur";
    }
}
