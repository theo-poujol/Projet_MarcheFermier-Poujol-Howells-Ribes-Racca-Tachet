package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Label;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Miel;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;

import java.time.LocalDate;

public class MarcheFermier {

    public static void main (String[] args){
        ProduitFermier produitFermier = new Miel(LocalDate.now(),200);

        System.out.println(produitFermier.getPeremptionDate());

        System.out.println(produitFermier.getLabels());

        Label label = new Label("Loris", "JE FAIS RIEN DEPUIS 1H30");

        produitFermier.addLabel(label);

        for (Label currentLabel : produitFermier.getLabels()) {
            System.out.println("Title " + label.getTitle());
            System.out.println("Desc : " + label.getDescription());
        }
    }
}
