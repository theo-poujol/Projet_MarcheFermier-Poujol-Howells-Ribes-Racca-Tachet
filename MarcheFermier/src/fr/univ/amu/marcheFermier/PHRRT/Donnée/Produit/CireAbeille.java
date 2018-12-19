package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public class CireAbeille extends ProduitApiculture {

    public CireAbeille(LocalDate peremptionDate, int amount) {
        super(peremptionDate,"Cire Abeille", amount);
    }

}
