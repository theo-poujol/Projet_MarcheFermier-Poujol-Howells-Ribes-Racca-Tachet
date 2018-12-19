package fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste;


import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughtMoneyException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Grossiste extends Acheteur {


    private ArrayList<ProduitFermier> sellProducts = new ArrayList<>();


    public Grossiste(double money, String pseudo) {
        super(money, pseudo);
    }



    public void sellMyProduct(ProduitFermier product, int cap) {
        for (ProduitFermier p : sellProducts) {
            if (p.equals(product)) {
                PropositionVente pv = new PropositionVente(this,product);
            }
        }
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
