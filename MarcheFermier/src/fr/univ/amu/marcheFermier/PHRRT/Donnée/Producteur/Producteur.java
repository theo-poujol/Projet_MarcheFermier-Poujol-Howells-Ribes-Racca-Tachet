package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;

import java.util.ArrayList;
import java.util.List;

public class Producteur extends Acheteur {

    private List<ProduitFermier> stock = new ArrayList<>();

    public Producteur(double money, String pseudo) {
        super(money, pseudo);
    }


    public  List<ProduitFermier> getStock() {
        return stock;
    }


    private boolean bio = false;



    public void produire() {

    }
}
