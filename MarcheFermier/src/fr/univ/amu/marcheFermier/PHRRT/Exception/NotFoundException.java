package fr.univ.amu.marcheFermier.PHRRT.Exception;

public class NotFoundException extends Exception {
    /**
     * se leve si quelqun tente d'utiliser un produit qui n'est plus ou pas disponible
     * @return
     */
    @Override
    public String getMessage() {
        return "L'objet n'est pas présent dans votre stock";
    }
}
