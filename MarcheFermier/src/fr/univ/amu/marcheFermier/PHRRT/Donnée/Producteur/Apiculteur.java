package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class Apiculteur extends Producteur implements DecorateurProducteur{

    private Producteur producteurADecorer; // à modifier

    public Apiculteur(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }



    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("je produis du miel");



    }
}
