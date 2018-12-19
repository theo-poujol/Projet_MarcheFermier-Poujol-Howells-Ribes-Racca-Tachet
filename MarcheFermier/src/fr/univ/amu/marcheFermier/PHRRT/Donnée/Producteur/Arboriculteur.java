package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class Arboriculteur extends Producteur {
    private Producteur producteurADecorer; // à modifier

    public Arboriculteur(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("je produis des arbres");
    }
}
