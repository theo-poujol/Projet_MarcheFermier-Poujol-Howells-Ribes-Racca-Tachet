package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public abstract class ProduitBio extends ProduitFermier {


    public ProduitBio(LocalDate peremptionDate,String name, int amount) {
        super(peremptionDate,name, amount);
    }
}

