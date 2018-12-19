package fr.univ.amu.marcheFermier.PHRRT.Traitement;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;

import java.util.List;
import java.util.Random;

public class Controleur {

    private static Controleur instance;

    private Controleur() {
    }

    public static Controleur getInstance() {
        if (instance == null) {
            instance = new Controleur();
        }
        return instance;
    }

    public Acheteur choisirAcheteur(PropositionVente propositionVente){
        int max = propositionVente.getMesAcheteurs().size()-1;
        int min = 0;
        Random r = new Random();
        int acheteurSelectionne;
        acheteurSelectionne = r.nextInt(((max - min) + 1) + min); //choisis un nombre entre 0 et le nombre d'acheteurs dans le tableau
        return propositionVente.getMesAcheteurs().get(acheteurSelectionne); // renvoie l'instance du tableau correspondant au random
        //for (Acheteur acheteur: propositionVente.getMesAcheteurs()){

        //}
    }

    private Acheteur choisirAcheteurPasDeMonopole(PropositionVente propositionVente){
        for (Acheteur acheteur: propositionVente.getMesAcheteurs()){

        }
    }

}
