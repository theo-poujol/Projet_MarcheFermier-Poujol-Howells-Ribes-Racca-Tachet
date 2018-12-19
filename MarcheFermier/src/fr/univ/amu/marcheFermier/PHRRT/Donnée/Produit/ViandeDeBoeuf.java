package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public class ViandeDeBoeuf extends Viande {


    public ViandeDeBoeuf(LocalDate peremptionDate, int amount) {
        super(peremptionDate,"Viande de Boeuf", amount);
    }
}
