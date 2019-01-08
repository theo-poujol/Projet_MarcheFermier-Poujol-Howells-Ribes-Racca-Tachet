package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class ProduitOrticulture extends ProduitFermier {

    /**
     * Constructeur ProduitOrticulture.
     *
     * @param peremptionDate
     * @param name
     * @param amount
     * @param proprietaire
     */
    public ProduitOrticulture(LocalDate peremptionDate, String name, int amount, Acheteur proprietaire) {
        super(peremptionDate, name, amount, proprietaire);
    }
}
