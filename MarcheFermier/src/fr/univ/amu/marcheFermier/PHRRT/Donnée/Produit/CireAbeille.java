package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class CireAbeille extends ProduitApiculture {

    /**
     * Constructeur CireAbeille.
     *
     * @param peremptionDate
     * @param amount
     * @param proprietaire
     */
    public CireAbeille(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate,"Cire Abeille", amount,proprietaire);
    }

}
