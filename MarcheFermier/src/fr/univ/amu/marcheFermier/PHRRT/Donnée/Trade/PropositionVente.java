package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;

import java.util.ArrayList;

public class PropositionVente { //Une Proposition de vente terminée devient une Transaction, qui sera elle-même insérée dans le Livre de Marché

    private Acheteur monVendeur; //Qui vend
    private ProduitFermier monProduit; // Ce qu'il vend
    private Double prix;
    private Acheteur monAcheteurChoisi; // choisi par l'AMF
    private ArrayList<Acheteur> mesAcheteurs; //Acheteurs potentiels
    private boolean isValid; //True si l'AMF valide l'annonce, celle ci devient visible
    public void afficher(){ // à implémenter
        System.out.println("Ceci est une proposition de vente");
    }



    public PropositionVente(Producteur monVendeur, ProduitFermier monProduit, int prix) {

        this.monVendeur = monVendeur;
        this.monProduit = monProduit;
        //this.prix = monProduit.setPrix();
    }
    public Transaction vendre() {

        try {
            this.monAcheteurChoisi.retirerArgent(this.getPrix());
            this.monVendeur.ajouterArgent(this.getPrix());
            return new Transaction(); // à définir
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
            return null;
        }

    }





    public Acheteur getMonVendeur() {
        return monVendeur;
    }

    public void setMonVendeur(Producteur monVendeur) {
        this.monVendeur = monVendeur;
    }

    public ProduitFermier getMonProduit() {
        return monProduit;
    }

    public void setMonProduit(ProduitFermier monProduit) {
        this.monProduit = monProduit;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public ArrayList<Acheteur> getMesAcheteurs() {
        return mesAcheteurs;
    }

    public void setMesAcheteurs(ArrayList<Acheteur> mesAcheteurs) {
        this.mesAcheteurs = mesAcheteurs;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }


}
