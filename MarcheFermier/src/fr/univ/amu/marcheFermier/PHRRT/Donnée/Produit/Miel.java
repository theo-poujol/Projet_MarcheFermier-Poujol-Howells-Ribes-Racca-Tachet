package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public class Miel extends ProduitApiculture {


    public Miel(LocalDate peremptionDate, double prix) {
        super(peremptionDate, prix);
    }

    @Override
    public void valider() {

    }
}
