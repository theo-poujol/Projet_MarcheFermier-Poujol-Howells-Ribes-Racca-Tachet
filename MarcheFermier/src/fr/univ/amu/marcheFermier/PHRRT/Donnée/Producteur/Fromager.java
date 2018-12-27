package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Emmental;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Reblochon;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotENoughtCapacityException;

import java.time.LocalDate;

public class Fromager extends Producteur implements DecorateurProducteur {

    private Producteur producteurADecorer;

    public Fromager(Producteur producteurADecorer) {
        super(producteurADecorer.getMoney(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();

        System.out.println("Je produit du fromage");
        //Production Reblochon

        ProduitFermier reblochon = new Reblochon(LocalDate.now(),1,this);

        //production d'emmental

        ProduitFermier emmental = new Emmental(LocalDate.now(),1,this);

        try {
            for (ProduitFermier produitFermier : producteurADecorer.getStock()) {
                addProduit(produitFermier);
            }
            addProduit(reblochon);
            addProduit(emmental);
        } catch (NotENoughtCapacityException e) {
            e.printStackTrace();
        }

    }
}
