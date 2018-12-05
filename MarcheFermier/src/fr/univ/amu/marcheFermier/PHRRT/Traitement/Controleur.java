package fr.univ.amu.marcheFermier.PHRRT.Traitement;

public class Controleur {

    private Controleur instance;

    private Controleur() {
    }

    public Controleur getInstance() {
        if (instance == null) {
            instance = new Controleur();
        }
        return instance;
    }

}
