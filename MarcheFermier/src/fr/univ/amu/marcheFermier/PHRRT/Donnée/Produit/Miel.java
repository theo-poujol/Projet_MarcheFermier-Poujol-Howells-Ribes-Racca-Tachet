package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class Miel extends ProduitApiculture {

    public Miel(LocalDate peremptionDate, int amount, Acheteur proprietaire) {
        super(peremptionDate,"Miel", amount, proprietaire);
    }

}
