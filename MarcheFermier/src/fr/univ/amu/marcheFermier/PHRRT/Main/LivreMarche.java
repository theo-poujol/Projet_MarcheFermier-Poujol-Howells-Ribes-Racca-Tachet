package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Transaction;

import java.util.ArrayList;
import java.util.List;

public class LivreMarche {
    private List<Transaction> mesTransactions;

    public LivreMarche() {
        this.mesTransactions = null;
    }

    public List<Transaction> getMesTransactions() {
        return mesTransactions;
    }

    public void addTransaction(Transaction t ) {
        this.mesTransactions.add(t);
    }
    public void afficher(){
        for (Transaction t : mesTransactions){
            System.out.println(t.getVente());
            System.out.println(t.getDate());
        }
    }
}
