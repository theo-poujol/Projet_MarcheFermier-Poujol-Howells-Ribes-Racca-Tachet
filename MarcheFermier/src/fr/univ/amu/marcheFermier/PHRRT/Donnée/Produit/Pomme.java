package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class Pomme extends ProduitOrticulture {

    /**
     * Constructeur Pomme.
     *
     * @param peremptionDate
     * @param amount
     * @param proprietaire
     */
    public Pomme(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate, "Pomme", amount, proprietaire);
    }
}
