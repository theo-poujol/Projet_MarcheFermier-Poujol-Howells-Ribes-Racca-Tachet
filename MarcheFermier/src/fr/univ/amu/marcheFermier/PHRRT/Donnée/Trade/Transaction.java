package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;


import java.util.ArrayList;
import java.util.HashMap;

public class Transaction {
    /**
     * Une Proposition de vente terminée devient une Transaction, qui sera elle-même insérée dans le Livre de Marché
     */


    private Acheteur monVendeur; //Qui vend
    private ProduitFermier monProduit; // Ce qu'il vend
    private int prix; // Prix du produit dans la proposition de vente
    private int quantite;  //Quantité du produit dans la proposition de vente
    private ArrayList<Acheteur> mesAcheteurs; //Acheteurs potentiels
    private HashMap<String, Acheteur> mesAcheteursVendeurs; //Acheteurs et vendeurs sur le marché
    private boolean isValid; //True si l'AMF valide l'annonce, celle ci devient visible
    public void afficher(){
        System.out.println("Ceci est une proposition de vente");
    }


    /**
     *
     * @param monVendeur  : Celui qui vend le produit
     * @param monProduit  : Produit vendu
     * @param quantite    : Quantité du produit
     */
    public Transaction(Acheteur monVendeur, ProduitFermier monProduit, int quantite) {
        this.monVendeur = monVendeur;
        this.monProduit = monProduit;
        this.quantite = quantite;


        //this.prix = monProduit.setPrix();
    }



    /**
     * Getter getMonVendeur retourne "monVendeur".
     *
     * @return monVendeur qui est la personne qui vend le produit.
     */

    public Acheteur getMonVendeur() {
        return monVendeur;
    }

    /**
     *Setter setMonVendeur qui set le monVendeur
     *
     * @param monVendeur
     */
    public void setMonVendeur(Producteur monVendeur) {
        this.monVendeur = monVendeur;
    }

    /**
     *getter getMonProduit qui retourne le produit qu'il vend.
     *
     * @return monProduit
     */
    public ProduitFermier getMonProduit() {
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
    public int getPrix() {
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

    /**
     *getter getMesAcheteurs qui retourne les acheteurs.
     *
     * @return mesAcheteurs.
     */
    public ArrayList<Acheteur> getMesAcheteurs() {
        return mesAcheteurs;
    }

    /**
     *setter setMesAcheteurs
     *
     * @param mesAcheteurs
     */
    public void setMesAcheteurs(ArrayList<Acheteur> mesAcheteurs) {
        this.mesAcheteurs = mesAcheteurs;
    }

    /**
     *isValid est un boolean qui permet a l'AMF de rendre une annonce visible ou non.
     *
     * @return isValid
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     *setter setValid qui decide si l'annonce est visible ou non.
     *
     * @param valid
     *          si l'AMF valide l'annonce, celle ci devient visible
     */
    public void setValid(boolean valid) {
        isValid = valid;
    }




}