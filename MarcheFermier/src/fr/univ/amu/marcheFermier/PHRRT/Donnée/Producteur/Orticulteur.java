package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Iris;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Pomme;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Tomate;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;

import java.time.LocalDate;

public class Orticulteur extends Producteur implements DecorateurProducteur{
    private Producteur producteurADecorer;

    /**
     * Constructeur d'Orticulteur.
     *
     * @param producteurADecorer
     */
    public Orticulteur(Producteur producteurADecorer) {
        super(producteurADecorer.getArgent(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    /**
     * Permet de produire des produits de l'orticulture .
     */
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
        } catch (NotEnoughCapacityException e) {

            e.printStackTrace();
        }
    }
}
