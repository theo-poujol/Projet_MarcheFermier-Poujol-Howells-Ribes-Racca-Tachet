package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class Orticulteur extends Producteur implements DecorateurProducteur{
    private Producteur producteurADecorer;

    public Orticulteur(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("je produis du fruits, des fleurs et des légumes");
    }
}
