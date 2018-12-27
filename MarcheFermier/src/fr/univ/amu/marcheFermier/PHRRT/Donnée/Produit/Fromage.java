package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public abstract class Fromage extends ProduitFermier {

    public Fromage(LocalDate peremptionDate, double prix, int quantite) {
        super(peremptionDate, prix, quantite);
    }
}
