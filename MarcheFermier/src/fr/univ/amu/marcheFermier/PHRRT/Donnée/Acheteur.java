package fr.univ.amu.marcheFermier.PHRRT.Donnée;


import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughtMoneyException;

import java.util.ArrayList;
import java.util.List;

public class Acheteur {


    private List<ProduitFermier> stock = new ArrayList<>();
    private double argent;
    private String pseudo;

    public Acheteur(double argent, String pseudo) {
        this.argent = argent;
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }




    public  List<ProduitFermier> getStock() {
        return stock;
    }
    public double getArgent() {
        return argent;
    }
    public void retirerArgent(Double budget)  {
        argent -= budget;

    }
    public void ajouterArgent(Double budget) {
        argent += budget;
    }
}

