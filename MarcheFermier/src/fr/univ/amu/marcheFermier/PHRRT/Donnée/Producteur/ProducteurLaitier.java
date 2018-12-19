package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class ProducteurLaitier extends Producteur implements DecorateurProducteur{

    private Producteur producteurADecorer;


    public ProducteurLaitier(Producteur producteurADecorer) {
        super(producteurADecorer.getMoney(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;

    }


    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("Je produis du lait");

    }
}
