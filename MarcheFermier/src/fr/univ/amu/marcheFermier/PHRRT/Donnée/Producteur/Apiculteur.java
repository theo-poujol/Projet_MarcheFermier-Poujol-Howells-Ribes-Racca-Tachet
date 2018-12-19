package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitApiculture;

public class Apiculteur extends Producteur implements DecorateurProducteur{

    private Producteur producteurADecorer; // à modifier

    public Apiculteur(double money, String pseudo, Producteur producteurADecorer) {
        super(money, pseudo);
        this.producteurADecorer = producteurADecorer;
    }



    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("je produis du miel");
    }
}
