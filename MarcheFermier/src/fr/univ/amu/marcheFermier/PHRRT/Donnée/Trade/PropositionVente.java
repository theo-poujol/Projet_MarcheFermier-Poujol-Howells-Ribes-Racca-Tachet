package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste.Grossiste;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;

import java.util.ArrayList;
import java.util.HashMap;

public class PropositionVente {
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
    public PropositionVente(Acheteur monVendeur, ProduitFermier monProduit, int quantite) {
        this.monVendeur = monVendeur;
        this.monProduit = monProduit;
        this.quantite = quantite;


        //this.prix = monProduit.setPrix();
    }


    /**
     * Renvoie le produit de la proposition de vente
     *
     * @return monProduit
     */

    public ProduitFermier getMonProduit() {
        return monProduit;
    }



}
