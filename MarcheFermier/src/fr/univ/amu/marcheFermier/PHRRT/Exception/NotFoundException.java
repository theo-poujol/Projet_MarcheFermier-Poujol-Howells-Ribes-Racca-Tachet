package fr.univ.amu.marcheFermier.PHRRT.Exception;

public class NotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "L'objet n'est pas présent dans votre stock";
    }
}
