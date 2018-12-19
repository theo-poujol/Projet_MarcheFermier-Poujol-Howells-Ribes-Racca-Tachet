package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Viande;

public class ProducteurDeViande extends Producteur implements DecorateurProducteur {

    private Producteur producteurADecorer;

    public ProducteurDeViande(double money, String pseudo, Producteur producteurADecorer) {
        super(money, pseudo);
        this.producteurADecorer = producteurADecorer;
    }



    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("Je produis de la bonne viande");

    }
}
