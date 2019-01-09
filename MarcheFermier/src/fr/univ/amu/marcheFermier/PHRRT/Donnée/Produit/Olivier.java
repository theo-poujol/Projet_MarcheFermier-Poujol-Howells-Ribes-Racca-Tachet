package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;

public class Olivier extends ProduitArboricole {
    public Olivier(LocalDate peremptionDate,int amount, Acheteur proprietaire) {
        super(peremptionDate, "Olivier", amount, proprietaire);
    }
}
