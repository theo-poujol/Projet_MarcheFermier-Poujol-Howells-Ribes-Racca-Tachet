package fr.univ.amu.marcheFermier.PHRRT.Donnée;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;

import java.util.ArrayList;
import java.util.List;

public class Acheteur {


    private List<ProduitFermier> stock = new ArrayList<>();
    private double money;


    public  List<ProduitFermier> getStock() {
        return stock;
    }
    public double getMoney() {
        return money;
    }
}
