package fr.univ.amu.marcheFermier.PHRRT.Traitement;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Label;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Main.Marche;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dorianosaure on 02/01/2019.
 */
public class Menu {

    private Marche marche;

    public Menu(Marche marche) {
        this.marche = marche;
    }

    public void start() {
        mainMenu();
    }

    private void mainMenu() {

        mainMenuView();

        String choix = getKeyboardEntry();

        switch (choix) {
            case "1":
                menuController();
                break;
            case "2":
                menuSeller();
                break;
            case "3":
                menuIteration();
                break;
            case "4":
                menuBuyers();
                break;
            default:
                mainMenu();
                break;
        }

    }

    private static String getKeyboardEntry() {

        BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));

        try {
            return entry.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    private void mainMenuView() {
        System.out.println("########################");
        System.out.println("#####Menu principal#####");
        System.out.println("########################");

        System.out.println("1) Valider offres (controlleur)");
        System.out.println("2) Mettre en vente");
        System.out.println("3) Produire (itération)");
        System.out.println("4) Acheter");
    }

    public void menuController() {

        menuControllerView();

        String entry = getKeyboardEntry();
        if (entry.equalsIgnoreCase("x")) {
            mainMenu();
            return;
        }
        int choix = Integer.getInteger(entry);

        if (choix < marche.getWaitingValidationProduct().size()) {
            ProduitFermier productChosen = marche.getWaitingValidationProduct().get(choix);

            marche.getAmf().valider(productChosen);
        }
        menuController();
    }

    public void menuSeller() {
        menuSellerView();

        String entry = getKeyboardEntry();
        if (entry.equalsIgnoreCase("x")) {
            mainMenu();
            return;
        }
        int choix = Integer.getInteger(entry);

        if (choix < marche.getParticipants().size()) {
            Acheteur acheteur  = marche.getParticipants().get(choix);

            menuSellerStock(acheteur);

            String entry1 = getKeyboardEntry();
            if (entry.equalsIgnoreCase("x")) {
                mainMenu();
                return;
            }

            int produit = Integer.getInteger(entry);

            marche.sell(acheteur,produit);
        }
        else menuSeller();
    }
    

    public void menuIteration() {
        menuIterationView();
    }

    public void menuBuyers() {
        menuBuyersView();
    }

    private void menuControllerView() {
        System.out.println("########################");
        System.out.println("########Menu ASF########");
        System.out.println("########################");

        int index = 0;

        for (ProduitFermier currentProduit : marche.getWaitingValidationProduct()) {
            marche.getAmf().inspecter(currentProduit, index);
            ++index;
        }

        System.out.println("x)menu principal");
    }

    private void menuSellerView() {
        System.out.println("########################");
        System.out.println("######Menu Vendeur######");
        System.out.println("########################");

        int index = 0;

        for (Acheteur acheteur : marche.getParticipants()) {
            System.out.println(index +") " + acheteur.getPseudo());
            System.out.println("#Stock : ");
            for (ProduitFermier produitFermier : acheteur.getStock()) {
                System.out.println("-" + produitFermier.getName() + " : " + produitFermier.getAmount());
            }
        }
        System.out.println("x)menu principal");
    }

    private void menuSellerStock(Acheteur acheteur) {
        System.out.println("########################");
        System.out.println("######" + acheteur.getPseudo() + "######");
        System.out.println("########################");

        int index = 0;

        for (ProduitFermier produitFermier : acheteur.getStock()) {
            System.out.println(index+") " + produitFermier.getName());
            System.out.println("#quantité : " + produitFermier.getAmount());
        }
        System.out.println("x)menu principal");
    }

    public int menuSellerProduct(ProduitFermier produitFermier) {
        menuSellerProductView(produitFermier);

        String entry = getKeyboardEntry();

        return Integer.getInteger(entry);
    }
    private void menuSellerProductView(ProduitFermier produitFermier) {
        System.out.println("Indiquer votre prix pour " + produitFermier.getAmount() + "de " + produitFermier.getName());
    }

    private void menuIterationView() {
        System.out.println("########################");
        System.out.println("#####Menu Production####");
        System.out.println("########################");
    }

    private void menuBuyersView() {
        System.out.println("########################");
        System.out.println("#######Menu Achat#######");
        System.out.println("########################");
    }
}
