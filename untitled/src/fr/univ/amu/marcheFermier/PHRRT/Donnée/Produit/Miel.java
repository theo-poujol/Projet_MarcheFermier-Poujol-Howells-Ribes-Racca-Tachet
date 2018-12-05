package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public class Miel extends ProduitFermier {


    public Miel(LocalDate peremptionDate, double prix) {
        super(peremptionDate, prix);
    }

    @Override
    public void valider() {

    }
}
