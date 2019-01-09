package fr.univ.amu.marcheFermier.PHRRT.Donnée.CentraleAchat;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CentraleAchat extends Acheteur{

    private List<Acheteur> membres = new ArrayList<Acheteur>(); // Liste des membres
    private List<Transaction> mesCommandes = new ArrayList<Transaction>(); // Liste des commandes
    private double promotion = 0;


    /**
     * Constructeur CentraleAchat.
     *
     * @param money
     * @param pseudo
     */
    public CentraleAchat(double money, String pseudo) {
        super(money, pseudo);
    }


    /**
     * Permet d'ajouter un membre à la Centrale d'achat.
     *
     * @param acheteur
     */
    public void ajouterMembre(Acheteur acheteur) {
        this.membres.add(acheteur);
    }

    /**
     * Permet de supprimer un membre à la Centrale d'achat.
     *
     * @param acheteur
     */
    public void retirerMembre(Acheteur acheteur) {
        this.membres.remove(acheteur);
    }

    /**
     *Permet d'ajouter une commande à la Centrale d'achat.
     *
     * @param pv
     */
    public void ajouterCommande(Transaction pv) {
        this.mesCommandes.add(pv);
    }

    /**
     * Permet de supprimer une commande à la Centrale d'achat.
     *
     * @param pv
     */
    public void retirerCommande(Transaction pv) {
        this.mesCommandes.remove(pv);
    }


}
