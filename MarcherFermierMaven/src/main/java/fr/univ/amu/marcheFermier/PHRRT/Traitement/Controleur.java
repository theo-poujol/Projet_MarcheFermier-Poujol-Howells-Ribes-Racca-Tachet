package fr.univ.amu.marcheFermier.PHRRT.Traitement;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Label;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Transaction;

import java.util.Random;

public class Controleur {

    private static Controleur instance;

    /**
     * contructeur prive
     */
    private Controleur() {

    }

    /**
     * cree une instance de controleur, permet de garder le constructeur en private
     * @return instance
     */
    public static Controleur getInstance() {
        if (instance == null) {
            instance = new Controleur();
        }
        return instance;
    }


    /**
     * designe un acheteur aleatoirement si plusieurs pretendants
     * @param transaction
     * @return Acheteurselectionné
     */
    /*public Acheteur choisirAcheteur(Transaction transaction){
        int max = transaction.get().size()-1;
        int min = 0;
        Random r = new Random();
        int acheteurSelectionne;
        acheteurSelectionne = r.nextInt(((max - min) + 1) + min); //choisis un nombre entre 0 et le nombre d'acheteurs dans le tableau
        return transaction.getMesAcheteurs().get(acheteurSelectionne); // renvoie l'instance du tableau correspondant au random
        //for (Acheteur acheteur: transaction.getMesAcheteurs()){

        //}
    }

    private Acheteur choisirAcheteurPasDeMonopole(Transaction transaction){
        for (Acheteur acheteur: transaction.getMesAcheteurs()){
            System.out.println("sku");
        }
        return null;
    }*/

    /**
     * donne toutes les infos sur un produit
     * @param produitFermier
     * @param index
     */
    public void inspecter(ProduitFermier produitFermier, int index) {
        System.out.println(index + ") " + produitFermier.getName());
        if (produitFermier.isBio()) {
            System.out.println("#Le produit est bio");
        }
        System.out.println("#Le produit n'est pas bio");
        System.out.println("#propriétaire : " + produitFermier.getProprietaire().getPseudo());
        System.out.println("#Labels : ");
        for (Label currentLabel : produitFermier.getLabels()) {
            System.out.println("- Titre : " + currentLabel.getTitle());
            System.out.println("- desc : " + currentLabel.getTitle());
        }
        System.out.println("Nombre de produit : " + produitFermier.getAmount());
        System.out.println("------------------------------");
    }

    /**
     * valide un produit en passant son parametre a true
     * @param produitFermier
     */
    public void valider(ProduitFermier produitFermier) {
        produitFermier.valider();
    }

}
