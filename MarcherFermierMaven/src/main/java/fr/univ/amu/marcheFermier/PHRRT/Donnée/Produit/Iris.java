package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class Iris extends ProduitOrticulture {

    /**
     * Constructeur Iris.
     *
     * @param peremptionDate
     * @param amount
     * @param proprietaire
     */
    public Iris(LocalDate peremptionDate,int amount, Acheteur proprietaire) {
        super(peremptionDate, "Iris", amount, proprietaire);
    }
}
