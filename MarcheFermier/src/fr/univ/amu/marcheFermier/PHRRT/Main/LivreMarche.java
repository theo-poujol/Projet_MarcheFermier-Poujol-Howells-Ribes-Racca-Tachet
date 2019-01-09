package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Transaction;

import java.util.ArrayList;
import java.util.List;

public class LivreMarche {
    private List<Transaction> transactions ;

    /**
     * constructeur livreMarche
     */
    public LivreMarche() {
        this.transactions = new ArrayList<>();
    }

    /**
     * retourne toutes les transactions présentes dans le livre sous forme de liste
     * @return mesTransactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * ajoute une transaction t
     * @param t
     */
    public void addTransaction(Transaction t ) {
        this.transactions.add(t);
    }

}
