package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public abstract class ProduitBio extends ProduitFermier {


    public ProduitBio(LocalDate peremptionDate, double prix, int quantite) {
        super(peremptionDate, prix, quantite);
    }
}

