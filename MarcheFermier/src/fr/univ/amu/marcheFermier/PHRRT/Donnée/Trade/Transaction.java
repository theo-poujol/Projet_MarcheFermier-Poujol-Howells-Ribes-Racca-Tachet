package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Transaction {
    /**
     * Une Proposition de vente terminée devient une Transaction, qui sera elle-même insérée dans le Livre de Marché
     */


    private Acheteur vendeur; //Qui vend
    private Acheteur acheteur; // celui qui achete
    private ProduitFermier monProduit; // Ce qu'il vend
    private double prix; // Prix du produit dans la proposition de vente
    private int quantite;  //Quantité du produit dans la proposition de vente
    private LocalDate date;

    /**
     *
     * @param vendeur
     * @param acheteur
     * @param monProduit
     */

    public Transaction(Acheteur vendeur,Acheteur acheteur, ProduitFermier monProduit) {
        this.vendeur = vendeur;
        this.acheteur = acheteur;
        this.monProduit = monProduit;
        this.quantite = monProduit.getAmount();
        this.prix = monProduit.getPrix();
        this.date = LocalDate.now();
    }

    /**
     *
     * @return
     */
    public Acheteur getAcheteur() {
        return acheteur;
    }

    /**
     *
     * @return
     */

    public LocalDate getDate() {
        return date;
    }

    /**
     *
     * @return
     */

    public int getQuantite() {
        return quantite;
    }


    /**
     * Getter getMonVendeur retourne "monVendeur".
     *
     * @return monVendeur qui est la personne qui vend le produit.
     */

    public Acheteur getVendeur() {
        return vendeur;
    }

    /**
     *Setter setMonVendeur qui set le monVendeur
     *
     * @param monVendeur
     */
    public void setMonVendeur(Producteur monVendeur) {
        this.vendeur = monVendeur;
    }

    /**
     *getter getMonProduit qui retourne le produit qu'il vend.
     *
     * @return monProduit
     */
    public ProduitFermier getProduit() {
        return monProduit;
    }

    /**
     *Setter setMonProduit
     *
     * @param monProduit
     * @return vente
     */
    public void setMonProduit(ProduitFermier monProduit) {
        this.monProduit = monProduit;
    }

    /**
     * getter getPrix qui return le prix du produit.
     * @return prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * setter setPrix qui set le prix du produit.
     *
     * @param prix
     *        prix est le prix du produit.
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }
}