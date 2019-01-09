package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Controleur;

import java.util.ArrayList;

/**
 * Une Proposition de vente terminée devient une Transaction, qui sera elle-même insérée dans le Livre de Marché
 */
public class PropositionVente {

    private Acheteur monVendeur; //Qui vend
    private ProduitFermier monProduit; // Ce qu'il vend
    private Double prix;
    private Acheteur monAcheteurChoisi; // choisi par l'AMF
    private ArrayList<Acheteur> mesAcheteurs; //Acheteurs potentiels
    private boolean isValid; //True si l'AMF valide l'annonce, celle ci devient visible
    public void afficher(){ // à implémenter
        System.out.println("Ceci est une proposition de vente");
    }


    /**
     * Constructeur PropositionVente.
     *
     * @param monVendeur
     * @param monProduit
     * @param prix
     */
    public PropositionVente(Producteur monVendeur, ProduitFermier monProduit, int prix) {

        this.monVendeur = monVendeur;
        this.monProduit = monProduit;
        //this.prix = monProduit.setPrix();
    }

    /**
     * vends un produit en évitant les manques d'argent
     * @return new Transaction(this)
     */
    public Transaction vendre() {

        try {
            Controleur control = Controleur.getInstance();
            monAcheteurChoisi = control.choisirAcheteur(this);
            this.monAcheteurChoisi.retirerArgent(this.getPrix());
            this.monVendeur.ajouterArgent(this.getPrix());
            return new Transaction(this);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
            return null;
        }

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
     */
    public void setMonProduit(ProduitFermier monProduit) {
        this.monProduit = monProduit;
    }

    /**
     *getter getPrix qui return le prix du produit.
     *
     * @return prix
     *          prix est le prix du produit.
     */
    public Double getPrix() {
        return prix;
    }

    /**
     * setter setPrix qui set le prix du produit.
     *
     * @param prix
     *        prix est le prix du produit.
     */
    public void setPrix(Double prix) {
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
