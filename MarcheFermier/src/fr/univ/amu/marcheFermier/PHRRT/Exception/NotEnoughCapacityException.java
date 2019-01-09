package fr.univ.amu.marcheFermier.PHRRT.Exception;

public class NotEnoughCapacityException extends Exception{
    @Override
    public String getMessage() {
        return "Vous n'avez pas la quantité nécessaire pour vendre ce produit";
    }
}
