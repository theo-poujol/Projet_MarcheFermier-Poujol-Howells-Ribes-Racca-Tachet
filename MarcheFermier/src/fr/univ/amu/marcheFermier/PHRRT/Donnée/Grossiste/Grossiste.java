package fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste;


import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitEncheres;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughtMoneyException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Grossiste extends Acheteur {


    private ArrayList<ProduitFermier> sellProducts = new ArrayList<>();


    public Grossiste(double money, String pseudo) {
        super(money, pseudo);
    }



    public void sellMyProduct(ProduitFermier product, int cap) {

        try {
            for (ProduitFermier p : sellProducts) {
                if (sellProducts.contains(product)) {
                    if (product.getQuantite() < cap) throw new NotEnoughCapacityException();
                    else {
                        ProduitEncheres pe = new ProduitEncheres(product,cap);
                        PropositionVente pv = new PropositionVente(this,pe,pe.getQuantite());
                        product.setQuantite(product.getQuantite() - cap);
                    }

                }
            }
        }

        catch (NotEnoughCapacityException e) { e.getMessage(); }

    }

    public void buyProduct() {

    }
    public void immediateBuy() {} // Proposer au client de vendre immédiatement son produit à prix réduit à un grossite selon ce que les objets que recherche le grossite



    public ArrayList<ProduitFermier> getSellProducts() {
        return sellProducts;
    }

    public void setSellProducts(ArrayList<ProduitFermier> sellProducts) {
        this.sellProducts = sellProducts;
    }



}
