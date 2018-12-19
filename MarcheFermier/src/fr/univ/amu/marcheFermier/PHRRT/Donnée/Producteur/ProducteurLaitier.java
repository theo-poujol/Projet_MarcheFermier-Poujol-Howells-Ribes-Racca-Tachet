package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class ProducteurLaitier extends Producteur {

    private Producteur producteurADecorer;

    public ProducteurLaitier(double money, String pseudo) {
        super(money, pseudo);
    }


    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("Je produis du lait");

    }
}
