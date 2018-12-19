package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class ProducteurLaitier extends Producteur {

    private Producteur producteurADecorer;


    public ProducteurLaitier(Producteur producteurADecorer) {
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("Je produis du lait");

    }
}
