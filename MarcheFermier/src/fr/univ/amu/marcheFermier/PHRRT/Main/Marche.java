package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.*;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Controleur;

import java.util.ArrayList;
import java.util.List;

public class Marche {


    private String region;
    private List<ProduitFermier> lesProduitsFermier = new ArrayList<ProduitFermier>();
    private List<Producteur> lesProducteurs = new ArrayList<Producteur>();
    private LivreMarche livreMarche;
    private List<PropositionVente> lesPropositionsVentes = new ArrayList<PropositionVente>();
    private int etape = 0;
    private Controleur amf;
    private double cotisation = 0.0;

    public Marche(String region) {
        this.region = region;

    }

    /**
     * Renvoie où se situe le marché
     *
     * @return region
     */

    public String getRegion() {
        return region;
    }

    /**
     * Renvoie toutes les ventes actuelles sur le marché
     *
     * @return lesPropositionsVentes
     */

    public List<PropositionVente> getLesPropositionsVentes() {
        return lesPropositionsVentes;
    }

    /**
     * Affiche les produits en vente du marché
     */

    public void mesPropositionsVentes() {
        System.out.println('\n' + "Stock en " + this.getRegion() + '\n');
        for (PropositionVente pv : lesPropositionsVentes) {
            System.out.println(pv.getMonProduit().getName() + " " + pv.getMonProduit().getPrix() + " € " + pv.getMonProduit().getAmount() +
            ' ' + pv.getMonProduit().getProprietaire().getPseudo());
        }
    }


    /**
     * Cherche si un produit est présent sur le marché
     *
     * @param p  : produit
     * @return boolean
     */
    public boolean isPresent(ProduitEncheres p) {
        if (this.lesProduitsFermier.contains(p)) return true;
        else return false;
    }

    /**
     * Ajoute la proposition de vente au marché
     *
     * @param pv  : proposition de vente
     */

    public void addSale(PropositionVente pv) {
        this.lesPropositionsVentes.add(pv);
    }


    /**
     * Retire une proposition de vente du marché
     *
     * @param pv  : proposition de vente
     */

    public void removeSale(PropositionVente pv) {
        this.lesPropositionsVentes.remove(pv);
    }


}
