package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Iris;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Pomme;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Tomate;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotENoughtCapacityException;

import java.time.LocalDate;

public class Orticulteur extends Producteur implements DecorateurProducteur{
    private Producteur producteurADecorer;

    public Orticulteur(Producteur producteurADecorer) {
        super(producteurADecorer.getMoney(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();

        System.out.println("Je produit de l'orticulture");
        //production pomme
        ProduitFermier pomme = new Pomme(LocalDate.now(),1,this);
        //production tomate
        ProduitFermier tomate = new Tomate(LocalDate.now(), 1, this);
        //produition iris
        ProduitFermier iris = new Iris(LocalDate.now(), 1,this);

        try {
            for (ProduitFermier produitFermier : producteurADecorer.getStock()) {
                addProduit(produitFermier);
            }
            addProduit(pomme);
            addProduit(tomate);
            addProduit(iris);
        } catch (NotENoughtCapacityException e) {
            e.printStackTrace();
        }
    }
}
