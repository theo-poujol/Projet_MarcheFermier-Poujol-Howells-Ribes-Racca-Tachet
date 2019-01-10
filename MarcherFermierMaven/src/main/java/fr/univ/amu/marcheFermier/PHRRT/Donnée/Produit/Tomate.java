package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class Tomate extends ProduitOrticulture {

    /**
     * Constructeur Tomate.
     *
     * @param peremptionDate
     * @param amount
     * @param proprietaire
     */
    public Tomate(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate, "Tomate", amount, proprietaire);
    }
}
