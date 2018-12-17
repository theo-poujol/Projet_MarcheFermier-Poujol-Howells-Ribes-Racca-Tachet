package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public abstract class ProduitApiculture extends ProduitFermier {

    public ProduitApiculture(LocalDate peremptionDate, double prix) {
        super(peremptionDate, prix);
    }
}
