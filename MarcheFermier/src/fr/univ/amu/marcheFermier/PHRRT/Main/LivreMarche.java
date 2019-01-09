package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Transaction;

import java.util.ArrayList;
import java.util.List;

public class LivreMarche {
    private List<Transaction> mesTransactions;

    /**
     * constructeur livreMarche
     */
    public LivreMarche() {
        this.mesTransactions = null;
    }

    /**
     * retourne toutes les transactions présentes dans le livre sous forme de liste
     * @return mesTransactions
     */
    public List<Transaction> getMesTransactions() {
        return mesTransactions;
    }

    /**
     * ajoute une transaction t
     * @param t
     */
    public void addTransaction(Transaction t ) {
        this.mesTransactions.add(t);
    }

    /**
     * affiche les informations sur une transaction
     */
    public void afficher(){
        for (Transaction t : mesTransactions){
            System.out.println(t.getVente());
            System.out.println(t.getDate());
        }
    }
}
