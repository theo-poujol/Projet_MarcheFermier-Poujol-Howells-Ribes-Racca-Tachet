package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public abstract class Viande  extends ProduitFermier {

    public Viande(LocalDate peremptionDate,String name, int amount) {
        super(peremptionDate, name, amount);
    }
}
