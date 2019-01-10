package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProduitFermier {

    private String name;
    private LocalDate peremptionDate;
    private double prix = 0;
    private List<Label> labels = new ArrayList<>();
    private boolean bio = false;
    private boolean valide = false;
    private Acheteur proprietaire;
    private int amount = 0;


    /**
     * Constructeur produitFermier.
     *
     * @param peremptionDate
     * @param name
     * @param amount
     * @param proprietaire
     */
    public ProduitFermier(LocalDate peremptionDate,String name, int amount, Acheteur proprietaire) {
        this.peremptionDate = peremptionDate;
        this.name = name;
        this.amount = amount;
        this.proprietaire = proprietaire;
    }

    /**
     * Constructeur produitFermier.
     *
     * @param produitFermier
     */
    public ProduitFermier(ProduitFermier produitFermier) {
        this.name = produitFermier.getName();
        this.peremptionDate = produitFermier.getPeremptionDate();
        this.bio = produitFermier.isBio();
        this.valide = produitFermier.isValide();
        this.proprietaire = produitFermier.getProprietaire();
        this.labels = produitFermier.getLabels();
    }


    /**
     * Setter qui definie le proprietaire.
     *
     * @param proprietaire
     */
    public void setProprietaire(Acheteur proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * Ajoute un label.
     *
     * @param label
     */
    public void addLabel(Label label) {
        labels.add(label);
    }

    /**
     * Getter qui definie la date de peremption.
     *
     * @return peremptionDate
     */
    public LocalDate getPeremptionDate() {
        return peremptionDate;
    }


    /**
     * Getter retourne un label.
     *
     * @return labels
     */
    public List<Label> getLabels() {
        return labels;
    }

    /**
     * Setter qui definie si c'est un produit bio ou non.
     *
     * @param bio
     */
    public void setBio(boolean bio) {
        this.bio = bio;
    }

    /**
     * retourne si c'est un produit bio ou non.
     *
     * @return bio
     */
    public boolean isBio() {
        return bio;
    }

    /**
     * Definie si c'est un produit bio ou non.
     *
     * @return valide
     */
    public boolean isValide() {
        return valide;
    }

    /**
     * Permet de valider un produit.
     *
     */
    public void valider() {
        this.valide = true;
    }

    /**
     * Getter qui retourne le prix.
     *
     * @return prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Getter qui retourne le proprietaire.
     *
     * @return proprietaire
     */
    public Acheteur getProprietaire() {
        return proprietaire;
    }

    /**
     * Setter qui definie le prix.
     *
     * @param prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Getter qui retourne le nom.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter qui retourne un montant.
     *
     * @return amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter qui definie un montant.
     *
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
