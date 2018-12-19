package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class GeleeRoyale extends ProduitApiculture {

    public GeleeRoyale(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate,"Gelee Royale", amount, proprietaire);
    }

}
