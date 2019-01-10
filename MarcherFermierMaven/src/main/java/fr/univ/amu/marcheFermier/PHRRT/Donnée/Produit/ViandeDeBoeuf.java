package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class ViandeDeBoeuf extends ProduitBoucher {

    /**
     * Constructeur ViandeDeBoeuf.
     *
     * @param peremptionDate
     * @param amount
     * @param proprietaire
     */
    public ViandeDeBoeuf(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate,"Viande de Boeuf", amount, proprietaire);
    }
}
