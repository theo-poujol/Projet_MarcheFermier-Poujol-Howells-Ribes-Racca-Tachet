package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.CireAbeille;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.GeleeRoyale;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Miel;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;

import java.time.LocalDate;

public class Apiculteur extends Producteur implements DecorateurProducteur{

    private Producteur producteurADecorer; // à modifier

    public Apiculteur(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }



    @Override
    public void produire() {
        producteurADecorer.produire();

        System.out.println("Je produit du miel");
        //production miel
        ProduitFermier miel = new Miel(LocalDate.now(), 1, this);

        //production gelee
        ProduitFermier gelee = new GeleeRoyale(LocalDate.now(), 1 , this);

        //production cire
        ProduitFermier cire = new CireAbeille(LocalDate.now(), 1,this);

        try {

            for (ProduitFermier produitFermier : producteurADecorer.getStock()) {
                addProduit(produitFermier);
            }
            addProduit(miel);
            addProduit(gelee);
            addProduit(cire);
        } catch (NotEnoughCapacityException e) {

            e.printStackTrace();
        }


    }
}
