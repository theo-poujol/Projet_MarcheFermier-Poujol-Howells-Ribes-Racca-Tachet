package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ProduitFermier {

    private LocalDate peremptionDate;
    private double prix;
    private List<Label> labels = new ArrayList<>();


    public ProduitFermier(LocalDate peremptionDate, double prix) {
        this.peremptionDate = peremptionDate;
        this.prix = prix;
    }

    public void addLabel(Label label) {
        labels.add(label);
    }

    public LocalDate getPeremptionDate() {
        return peremptionDate;
    }

    public double getPrix() {
        return prix;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public abstract void valider();
}
