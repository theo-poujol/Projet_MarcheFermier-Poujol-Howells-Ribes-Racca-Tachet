package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class LaitDeBrebis extends ProduitLaitier {
    public LaitDeBrebis(LocalDate peremptionDate,int amount, Acheteur proprietaire) {
        super(peremptionDate, "Lait de brebis", amount, proprietaire);
    }
}
