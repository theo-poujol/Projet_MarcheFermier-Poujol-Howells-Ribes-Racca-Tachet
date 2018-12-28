package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Cerisier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Olivier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;

import java.time.LocalDate;

public class Arboriculteur extends Producteur {
    private Producteur producteurADecorer; // à modifier

    public Arboriculteur(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("Je produit de l'arboriculture");


        //production olivier
        ProduitFermier olivier = new Olivier(LocalDate.now(),1,this);

        //production cerisier
        ProduitFermier cerisier = new Cerisier(LocalDate.now(),1,this);

        try {

            for (ProduitFermier produitFermier : producteurADecorer.getStock()) {
                addProduit(produitFermier);
            }
            addProduit(olivier);
            addProduit(cerisier);
        } catch (NotEnoughCapacityException e) {
            e.printStackTrace();
        }

    }
}
