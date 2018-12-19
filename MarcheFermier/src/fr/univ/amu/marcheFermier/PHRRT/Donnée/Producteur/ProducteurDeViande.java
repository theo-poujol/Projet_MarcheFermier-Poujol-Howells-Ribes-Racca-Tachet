package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

public class ProducteurDeViande extends Producteur implements DecorateurProducteur {

    private Producteur producteurADecorer;

    public ProducteurDeViande(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }



    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("Je produis de la bonne viande");

    }
}
