package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public abstract class Viande  extends ProduitFermier {

    public Viande(LocalDate peremptionDate, double prix) {
        super(peremptionDate, prix);
    }
}
