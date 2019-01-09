package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class ViandeDeCochon extends ProduitBoucher {
    public ViandeDeCochon(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate, "Viande de cochon", amount, proprietaire);
    }
}
