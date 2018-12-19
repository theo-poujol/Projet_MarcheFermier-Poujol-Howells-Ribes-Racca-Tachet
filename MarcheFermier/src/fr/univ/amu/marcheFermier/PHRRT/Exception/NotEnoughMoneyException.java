package fr.univ.amu.marcheFermier.PHRRT.Exception;

public class NotEnoughMoneyException extends Exception {
    @Override
    public String getMessage() {
        return "Vous n'avez pas assez d'argent";
    }
}
