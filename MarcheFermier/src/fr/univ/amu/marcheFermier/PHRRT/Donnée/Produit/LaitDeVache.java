package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class LaitDeVache extends ProduitLaitier {
    public LaitDeVache(LocalDate peremptionDate,int amount, Acheteur proprietaire) {
        super(peremptionDate, "Lait de vache", amount, proprietaire);
    }
}
