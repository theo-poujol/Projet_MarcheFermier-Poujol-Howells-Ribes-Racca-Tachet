package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import java.time.LocalDate;

public class Transaction {
    private PropositionVente vente;
    private LocalDate date;

    /**
     * Constructeur Transaction.
     *
     * @param vente
     */
    public Transaction(PropositionVente vente) {
        this.vente = vente;
        this.date = LocalDate.now();
    }

    /**
     * Getter qui retourne les ventes.
     *
     * @return vente
     */
    public PropositionVente getVente() {
        return vente;
    }

    /**
     * Getter qui retour la date.
     *
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

}
