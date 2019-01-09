package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.LaitDeBrebis;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.LaitDeVache;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotENoughtCapacityException;

import java.time.LocalDate;

public class ProducteurLaitier extends Producteur implements DecorateurProducteur{

    private Producteur producteurADecorer;


    public ProducteurLaitier(Producteur producteurADecorer) {
        super(producteurADecorer.getMoney(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;

    }


    @Override
    public void produire() {
        producteurADecorer.produire();

        //production lait de vache

        ProduitFermier laitDeVache = new LaitDeVache(LocalDate.now(),1,this);

        //production lait de brebis

        ProduitFermier laitDeBrebis = new LaitDeBrebis(LocalDate.now(),1,this);

        try {
            producteurADecorer.addProduit(laitDeVache);
            producteurADecorer.addProduit(laitDeBrebis);
        } catch (NotENoughtCapacityException e) {
            e.printStackTrace();
        }
    }
}
