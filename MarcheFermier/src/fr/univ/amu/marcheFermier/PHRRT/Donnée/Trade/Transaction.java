package fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade;

import java.time.LocalDate;

public class Transaction {
    private PropositionVente vente;
    private LocalDate date;

    public Transaction(PropositionVente vente) {
        this.vente = vente;
        this.date = LocalDate.now();
    }

    public PropositionVente getVente() {
        return vente;
    }

    public LocalDate getDate() {
        return date;
    }

}
