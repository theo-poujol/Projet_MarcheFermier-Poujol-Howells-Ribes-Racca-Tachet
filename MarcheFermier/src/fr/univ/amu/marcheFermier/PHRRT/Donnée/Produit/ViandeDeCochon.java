package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public class ViandeDeCochon extends Viande {
    public ViandeDeCochon(LocalDate peremptionDate, int amount) {
        super(peremptionDate, "Viande de cochon", amount);
    }
}
