package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Emmental;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Reblochon;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;

import java.time.LocalDate;

public class Fromager extends Producteur implements DecorateurProducteur {

    private Producteur producteurADecorer;

    public Fromager(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();


        //Production Reblochon

        ProduitFermier reblochon = new Reblochon(LocalDate.now(),1,this);

        //production d'emmental

        ProduitFermier emmental = new Emmental(LocalDate.now(),1,this);

        try {
            producteurADecorer.addProduit(reblochon);
            producteurADecorer.addProduit(emmental);
        } catch (NotEnoughCapacityException e) {
            e.printStackTrace();
        }

    }
}
