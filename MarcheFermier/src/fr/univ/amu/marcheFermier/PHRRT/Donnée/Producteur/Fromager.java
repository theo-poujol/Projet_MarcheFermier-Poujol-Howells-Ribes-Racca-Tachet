package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class Fromager extends Producteur implements DecorateurProducteur {

    private Producteur producteurADecorer;

    public Fromager(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("je produis du fromage");
    }
}
