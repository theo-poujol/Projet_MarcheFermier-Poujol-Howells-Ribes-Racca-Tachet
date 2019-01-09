package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ProduitFermier {

    private String name;
    private LocalDate peremptionDate;
    private double prix = 0;
    private List<Label> labels = new ArrayList<>();
    private boolean bio = false;
    private Acheteur proprietaire;
    private boolean isValide = false;
    private int amount = 0;




    public ProduitFermier(LocalDate peremptionDate,String name, int amount, Acheteur proprietaire) {
        this.peremptionDate = peremptionDate;
        this.name = name;
        this.amount = amount;
        this.proprietaire = proprietaire;
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
        this.isValide = true;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    public double getPrix() {
        return this.prix;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setProprietaire(Acheteur proprietaire) {
        this.proprietaire = proprietaire;
    }
}
