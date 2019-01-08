package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ViandeDeBoeuf;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ViandeDeCochon;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;

import java.time.LocalDate;

public class ProducteurDeViande extends Producteur implements DecorateurProducteur {

    private Producteur producteurADecorer;

    /**
     * Constructeur de ProducteurDeViande.
     *
     * @param producteurADecorer
     */
    public ProducteurDeViande(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }



    @Override
    /**
     * Permet de produire des produits bovins.
     */
    public void produire() {
        producteurADecorer.produire();

        System.out.println("Je produit de la viande");

        //production boeuf

        ProduitFermier boeuf = new ViandeDeBoeuf(LocalDate.now(), 1,this);

        //production cochon

        ProduitFermier cochon = new ViandeDeCochon(LocalDate.now(),1,this);

        try {

            for (ProduitFermier produitFermier : producteurADecorer.getStock()) {
                addProduit(produitFermier);
            }
            addProduit(boeuf);
            addProduit(cochon);
        } catch (NotEnoughCapacityException e) {

            e.printStackTrace();
        }

    }
}
