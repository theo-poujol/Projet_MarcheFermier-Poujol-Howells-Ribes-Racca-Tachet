package fr.univ.amu.marcheFermier.PHRRT.marche.affichage.Terminal;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.OrdreTrader;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Trader;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;
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

        selectMenu(choix);
    }

    private void selectMenu(String choix) {
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
            case "5":
                menuTrader();
                break;
            case "6":
                menuOrdre();
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
        System.out.println("5) trader");
        System.out.println("6) ordres");
    }

    public void menuController() {

        menuControllerView();

        String entry = getKeyboardEntry();
        if (entry.equalsIgnoreCase("x")) {
            mainMenu();
            return;
        }
        int choix = Integer.parseInt(entry);

        if (choix < getWaitingProductSize()) {
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
        int choix = Integer.parseInt(entry);

        if (choix < getParticipantsSize()) {
            Acheteur acheteur  = marche.getParticipants().get(choix);

            menuSellerStock(acheteur);

            String entry1 = getKeyboardEntry();
            if (entry1.equalsIgnoreCase("x")) {
                mainMenu();
                return;
            }

            int produit = Integer.parseInt(entry1);

            marche.sell(acheteur,produit);
        }
        else menuSeller();
    }


    public void menuIteration() {
        menuIterationView();
        System.out.println("#######Iteration######");
        marche.iteration();
    }

    public void menuBuyers() {
        menuBuyersView();

        String entry = getKeyboardEntry();
        if (entry.equalsIgnoreCase("x")) {
            mainMenu();
            return;
        }
        int choix = Integer.parseInt(entry);

        if (choix < getParticipantsSize()) {
            Acheteur acheteur  = marche.getParticipants().get(choix);

            marche.displayMarketListing();

            String entry1 = getKeyboardEntry();
            if (entry1.equalsIgnoreCase("x")) {
                mainMenu();
                return;
            }

            int produit = Integer.parseInt(entry1);

            System.out.println("Entrez le nombre de produit que vous vous souhaitez");
            int amount = Integer.parseInt(getKeyboardEntry());


            try {
                marche.buy(acheteur,produit,amount);
            } catch (NotEnoughMoneyException e) {
                e.printStackTrace();
            }
        }
        else menuBuyers();

    }



    private void menuBuyersView() {
        System.out.println("########################");
        System.out.println("#######Menu Achat#######");
        System.out.println("########################");

        marche.displayParticipantsMoney();

        System.out.println("x)menu principal");


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

        marche.displayParticipantsStock();
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
            ++index;
        }
        System.out.println("x)menu principal");
    }

    public int menuSellerProduct(ProduitFermier produitFermier) {
        menuSellerProductView(produitFermier);

        String entry = getKeyboardEntry();

        return Integer.parseInt(entry);
    }
    private void menuSellerProductView(ProduitFermier produitFermier) {
        System.out.println("Indiquer votre prix pour " + produitFermier.getAmount() + "de " + produitFermier.getName());
    }

    private void menuIterationView() {
        System.out.println("########################");
        System.out.println("#####Menu Production####");
        System.out.println("########################");
    }


    private void menuTrader() {
        menuTraderView();

        String entry = getKeyboardEntry();
        if (entry.equalsIgnoreCase("x")) {
            mainMenu();
            return;
        }
        int choix = Integer.parseInt(entry);


        if (choix < marche.getTraders().size()) {
            Trader trader = marche.getTraders().get(choix);

            menuTraderClientView(trader);

            choix = Integer.parseInt(getKeyboardEntry());

            if (choix < getParticipantsSize()) {
                Acheteur acheteur  = trader.getClients().get(choix);

                System.out.println("Entrez le nom du produit que vous voulez acheter");

                String productName = getKeyboardEntry();

                System.out.println("Entrez le prix maximum que vous cherchez");
                double maxPrice = Double.parseDouble(getKeyboardEntry());

                System.out.println("Entrez le nombre de produit que vous vous souhaitez");
                int amount = Integer.parseInt(getKeyboardEntry());

                trader.addOrder(new OrdreTrader(productName,amount,acheteur,maxPrice));
                mainMenu();
            }
        }
        else menuTrader();


    }

    private void menuTraderView() {
        System.out.println("########################");
        System.out.println("#######Menu Trader######");
        System.out.println("########################");

        marche.displayTraders();
        System.out.println("x)menu principal");

    }

    private void menuTraderClientView(Trader trader) {
        System.out.println("########################");
        System.out.println("#######Menu Trader######");
        System.out.println("########################");

        int index = 0;
        for (Acheteur acheteur : trader.getClients()) {
            System.out.println(index+") " + acheteur.getPseudo());
            System.out.println("#Argent : " + acheteur.getMoney());
            ++index;
        }
    }

    private int getParticipantsSize() {
        return marche.getParticipants().size();
    }

    private int getWaitingProductSize() {
        return marche.getWaitingValidationProduct().size();
    }

    public void errorMenu(String error) {
        System.out.println("########################");
        System.out.println("#######Menu Erreur######");
        System.out.println("########################");
        System.out.println(error);
        System.out.println("########################");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void menuOrdre() {

        for (Trader trader : marche.getTraders()) {
            System.out.println("########################");
            System.out.println("##########Ordres########");
            System.out.println("########################");
            System.out.println("###" + trader.getName() + "###");
            System.out.println("ordres : ");
            for (OrdreTrader ordre : trader.getOrdres()) {
                System.out.println("-" + ordre.getProductName());
                System.out.println("#Nombre : " + ordre.getAmount());
                System.out.println("#Maximum Price unit : " + ordre.getMaximumUnitPrice());
                System.out.println("#client : " + ordre.getOrderer().getPseudo());
            }
            System.out.println("########################");
        }
        mainMenu();
    }




}
