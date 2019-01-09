package fr.univ.amu.marcheFermier.PHRRT.Exception;

public class NullPriceException extends Exception {
    @Override
    public String getMessage() {
        return "Prix nul, mettre un prix valide.";
    }
}
