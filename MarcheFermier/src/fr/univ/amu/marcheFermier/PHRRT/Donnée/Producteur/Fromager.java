package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class Fromager implements DecorateurProducteur {

    private Producteur producteurADecorer;

    public Fromager(Producteur producteurADecorer) {
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("je produis du fromage");
    }
}
