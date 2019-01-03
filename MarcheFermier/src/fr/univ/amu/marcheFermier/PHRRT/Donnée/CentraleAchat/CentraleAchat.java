package fr.univ.amu.marcheFermier.PHRRT.Donnée.CentraleAchat;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;

import java.util.ArrayList;
import java.util.List;

public class CentraleAchat extends Acheteur{

    private List<Acheteur> membres = new ArrayList<Acheteur>(); // Liste des membres
    private List<PropositionVente> mesCommandes = new ArrayList<PropositionVente>(); // Liste des commandes
    private double promotion = 0;


    public CentraleAchat(double money, String pseudo) {
        super(money, pseudo);
    }



    public void ajouterMembre(Acheteur acheteur) {
        this.membres.add(acheteur);
    }

    public void retirerMembre(Acheteur acheteur) {
        this.membres.remove(acheteur);
    }

    public void ajouterCommande(PropositionVente pv) {
        this.mesCommandes.add(pv);
    }

    public void retirerCommande(PropositionVente pv) {
        this.mesCommandes.remove(pv);
    }


}
