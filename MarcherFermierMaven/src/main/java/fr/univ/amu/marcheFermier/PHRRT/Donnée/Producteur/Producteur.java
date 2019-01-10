package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;

import java.util.ArrayList;
import java.util.List;

public class Producteur extends Acheteur {

    private boolean bio = false;
    private int capacite = 50000000;

    /**
     * Constructeur de Producteur.
     *
     * @param money
     * @param pseudo
     */
    public Producteur(double money, String pseudo) {
        super(money, pseudo);
    }

    /**
     * Getter retourne le stock.
     *
     * @return getStock
     */
    public  List<ProduitFermier> getStock() {
        return super.getStock();
    }


    /**
     * Affiche "je produis".
     */
    public void produire() {
        System.out.println("je produis");
    }


    /**
     * Ajoute un produit.
     *
     * @param produitFermier
     * @throws NotEnoughCapacityException
     */
    public void addProduit(ProduitFermier produitFermier) throws NotEnoughCapacityException {

        //Check capacite
        int capaciteRestante = capacite - getCurrentCapacite();

        //si il n'y a plus de place on n'ajoute pas
        if (capaciteRestante == 0) return;

        if (produitFermier.getAmount() > capaciteRestante) {
            //on calcul le nombre de produit détruit par l'operation
            int deletedAmount = produitFermier.getAmount() - capaciteRestante;
            //on remplace le montant de produit par un montant qui rentre dans la capacite du producteur
            produitFermier.setAmount(capaciteRestante);
            //on leve une exception comme quoi des produits ont été perdus pour manque de place
            throw new NotEnoughCapacityException(produitFermier,deletedAmount);
        }

        if (bio) {
            produitFermier.setBio(true);
        }
        super.addProduit(produitFermier);



    }

    /**
     * Getter qui retourne la capacité.
     *
     * @return currentCapacite
     */
    private int getCurrentCapacite() {
        int currentCapacite = 0;
        for (ProduitFermier produitFermier : super.getStock()) {
            currentCapacite += produitFermier.getAmount();
        }
        return currentCapacite;
    }


    /**
     * Setter qui definie si c'est un produit bio ou non.
     *
     * @param bio
     */
    public void setBio(boolean bio) {
        this.bio = bio;
    }
}
