package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class Cerisier extends ProduitArboricole {

    /**
     * Constructeur Cerisier.
     *
     * @param peremptionDate
     * @param amount
     * @param proprietaire
     */
    public Cerisier(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate, "Cerisier", amount, proprietaire);
    }
}
