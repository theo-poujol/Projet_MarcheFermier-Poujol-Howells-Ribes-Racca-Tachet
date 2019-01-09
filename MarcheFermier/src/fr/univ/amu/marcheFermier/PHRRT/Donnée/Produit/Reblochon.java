package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class Reblochon extends ProduitFromager {

    /**
     * Constructeur Reblochon.
     *
     * @param peremptionDate
     * @param amount
     * @param proprietaire
     */
    public Reblochon(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate,"Reblochon", amount, proprietaire);
    }
}
