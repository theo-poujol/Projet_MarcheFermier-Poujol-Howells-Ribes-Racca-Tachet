package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public abstract class ProduitApiculture extends ProduitFermier {

    public ProduitApiculture(LocalDate peremptionDate, String name, int amount) {
        super(peremptionDate,name, amount);
    }
}
