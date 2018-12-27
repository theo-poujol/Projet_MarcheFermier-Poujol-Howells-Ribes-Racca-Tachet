package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;

public class ViandeDeBoeuf extends Viande {


    public ViandeDeBoeuf(LocalDate peremptionDate, double prix, int quantite) {
        super(peremptionDate, prix, quantite);
    }
}
