package fr.univ.amu.marcheFermier.PHRRT.Traitement;

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

        int choix = Integer.getInteger(getKeyboardEntry());

        ProduitFermier productChosen = marche.getWaitingValidationProduct().get(choix);

        marche.getAmf().valider(productChosen);
    }

    public void menuSeller() {
        menuSellerView();
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
    }

    private void menuSellerView() {
        System.out.println("########################");
        System.out.println("######Menu Vendeur######");
        System.out.println("########################");
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
