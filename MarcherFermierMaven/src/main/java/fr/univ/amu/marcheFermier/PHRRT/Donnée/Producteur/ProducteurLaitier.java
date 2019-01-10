package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.LaitDeBrebis;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.LaitDeVache;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;

import java.time.LocalDate;

public class ProducteurLaitier extends Producteur implements DecorateurProducteur{

    private Producteur producteurADecorer;


    /**
     * Constructeur de ProducteurLaitier.
     *
     * @param producteurADecorer
     */
    public ProducteurLaitier(Producteur producteurADecorer) {
        super(producteurADecorer.getMoney(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;

    }


    @Override
    /**
     *  Permet de produire des produits laitiers.
     */
    public void produire() {
        producteurADecorer.produire();


        System.out.println("Je produit du lait");

        //production lait de vache

        ProduitFermier laitDeVache = new LaitDeVache(LocalDate.now(),1,this);

        //production lait de brebis

        ProduitFermier laitDeBrebis = new LaitDeBrebis(LocalDate.now(),1,this);

        try {

            for (ProduitFermier produitFermier : producteurADecorer.getStock()) {
                addProduit(produitFermier);
            }
            addProduit(laitDeVache);
            addProduit(laitDeBrebis);
        } catch (NotEnoughCapacityException e) {
            e.printStackTrace();
        }
    }
}
