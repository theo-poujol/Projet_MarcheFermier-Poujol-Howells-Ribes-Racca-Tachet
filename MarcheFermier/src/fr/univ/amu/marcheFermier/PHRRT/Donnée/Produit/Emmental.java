package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class Emmental extends ProduitFromager {

    /**
     * Constructeur Emmental.
     *
     * @param peremptionDate
     * @param amount
     * @param proprietaire
     */
    public Emmental(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate, "Emmental", amount, proprietaire);
    }
}
