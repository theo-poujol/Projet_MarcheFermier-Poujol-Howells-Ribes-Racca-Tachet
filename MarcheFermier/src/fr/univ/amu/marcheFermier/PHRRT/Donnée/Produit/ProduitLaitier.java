package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public abstract class ProduitLaitier extends ProduitFermier {
    public ProduitLaitier(LocalDate peremptionDate, String name, int amount, Acheteur proprietaire) {
        super(peremptionDate,name, amount, proprietaire);
    }
}
