package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class Orticulteur extends Producteur {
    private Producteur producteurADecorer;

    public Orticulteur(Producteur producteurADecorer) {
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("je produis du fruits, des fleurs et des légumes");
    }
}
