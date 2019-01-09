package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public abstract class ProduitFromager extends ProduitFermier {

    /**
     * Constructeur ProduitFromager.
     *
     * @param peremptionDate
     * @param name
     * @param amount
     * @param proprietaire
     */

    public ProduitFromager(LocalDate peremptionDate, String name, int amount, Acheteur proprietaire) {
        super(peremptionDate, name, amount,proprietaire);
    }
}
