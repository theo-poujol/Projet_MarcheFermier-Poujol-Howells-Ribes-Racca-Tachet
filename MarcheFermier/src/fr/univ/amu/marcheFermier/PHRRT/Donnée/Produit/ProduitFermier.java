package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ProduitFermier {

    private LocalDate peremptionDate;
    private double prix = 0;
    private List<Label> labels = new ArrayList<>();
    private boolean bio = false;
    private Acheteur proprietaire;
    private boolean isValider = false;


    public ProduitFermier(LocalDate peremptionDate, double prix) {
        this.prix = prix;
        this.peremptionDate = peremptionDate;
    }

    public void addLabel(Label label) {
        labels.add(label);
    }

    public LocalDate getPeremptionDate() {
        return peremptionDate;
    }


    public List<Label> getLabels() {
        return labels;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public Acheteur getProprietaire() {
        return proprietaire;
    }

    public void valider() {
        this.isValider = true;
    }
}
