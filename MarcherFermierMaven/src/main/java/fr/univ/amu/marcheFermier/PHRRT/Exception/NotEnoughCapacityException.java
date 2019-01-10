package fr.univ.amu.marcheFermier.PHRRT.Exception;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;

public class NotEnoughCapacityException extends Exception {

    private ProduitFermier produitFermier;
    private int deletedAmount;

    /**
     * constructeur de l'exception, avec le produit concerne et la quantite supprimee
     * @param produitFermier
     * @param deletedAmount
     */
    public NotEnoughCapacityException(ProduitFermier produitFermier, int deletedAmount) {
        this.produitFermier = produitFermier;
        this.deletedAmount = deletedAmount;
    }

    /**
     * se leve si une capacite de stockage est trop petite et detruit le surplus
     * @return a string
     */
    @Override
    public String getMessage() {
        return deletedAmount + " unité(s) de " + produitFermier.getName()  + " ont été détruit par manque de capacité du producteur";
    }
}
