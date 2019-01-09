package fr.univ.amu.marcheFermier.PHRRT.Exception;


public class NotEnoughMoneyException extends Exception {

    /**
     * cette exception est levee lorsque n'importe quel acteur du marche souhaite effectuer une transaction
     * de fonds
     * @return
     */
    @Override
    public String getMessage() {
        return "Vous n'avez pas assez d'argent pour effectuer cette operation";
    }
}

