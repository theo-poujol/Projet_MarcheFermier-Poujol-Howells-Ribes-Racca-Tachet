package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public abstract class ViandeDeCochon extends Viande {
    public ViandeDeCochon(LocalDate peremptionDate, double prix, int quantite) {
        super(peremptionDate, prix, quantite);
    }
}
