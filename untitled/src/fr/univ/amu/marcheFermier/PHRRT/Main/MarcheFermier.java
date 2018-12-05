package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Miel;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;

import java.time.LocalDate;

public class MarcheFermier {

    public static void main (String[] args){
        ProduitFermier produitFermier = new Miel(LocalDate.now(),200);

        System.out.println(produitFermier.getPeremptionDate());

        System.out.println(produitFermier.getLabels());
    }
}
