package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitApiculture;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitBio;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitLaitier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Trader;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Controleur;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Menu;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.List;

public class Marche {
    private String region;
    private Menu menu;
    private List<ProduitFermier> productSell = new ArrayList<>();
    private List<ProduitFermier> waitingValidationProduct = new ArrayList<>();
    private List<Acheteur> participants = new ArrayList<>();
    private LivreMarche livreMarche; // à remplir après chaque transaction
    private Controleur amf; //unique par région
    private Trader trader;
    private int taxe;





    public Marche(String region, int taxe) {
        this.region = region;
        this.taxe = taxe;

        this.menu = new Menu(this);

        this.amf = Controleur.getInstance();

        this.trader = new Trader(this);
    }


    public void start() {
        //starting
        System.out.println("Starting market in " + region + "...");

        //affichage du menu
        menu.start();
    }

    public List<ProduitFermier> getWaitingValidationProduct() {
        return waitingValidationProduct;
    }

    public void iteration() {
        //validation waitingproduct
        validateWaitingProduct();
        //production
        product();
        //recherche du trader
        try {
            trader.checkMarket();
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }
        //retour au menu
        menu.start();
    }

    public List<Acheteur> getParticipants() {
        return participants;
    }

    public Controleur getAmf() {
        return amf;
    }

    public void sell(Acheteur acheteur, int indexProduit) {

        ProduitFermier produitFermier = acheteur.getStock().get(indexProduit);

        ProduitFermier sellProduct = new ProduitFermier(produitFermier);

        int price = menu.menuSellerProduct(produitFermier);

        sellProduct.setPrix(price);
        sellProduct.setAmount(produitFermier.getAmount());

        acheteur.getStock().remove(produitFermier);

        waitingValidationProduct.add(sellProduct);
        menu.start();
    }

    public void buy(Acheteur acheteur, int indexProduit, int amount) throws NotEnoughMoneyException {

        ProduitFermier produitFermier = productSell.get(indexProduit);



        if (acheteur.getArgent() >= produitFermier.getPrix()) {

            try {
                if (produitFermier.getAmount() > amount) {
                    ProduitFermier nonSelledProduct = new ProduitFermier(produitFermier);
                    int remainingAmount = produitFermier.getAmount() - amount;
                    nonSelledProduct.setAmount(remainingAmount);
                    double unitPrice = produitFermier.getPrix()/produitFermier.getAmount();
                    nonSelledProduct.setPrix(unitPrice*remainingAmount);
                    productSell.add(nonSelledProduct);

                    produitFermier.setAmount(amount);
                    produitFermier.setPrix(amount*unitPrice);
                }
                //ajout dans le stock de l'acheteur
                acheteur.addProduit(produitFermier);
                //retirer l'argent
                acheteur.retirerArgent(produitFermier.getPrix());
                //ajouter l'argent à l'ancien propriétaire (retirer les taxes)
                produitFermier.getProprietaire().addArgent(produitFermier.getPrix());
                //changer le propriétaire
                produitFermier.setProprietaire(acheteur);
                //mise à 0 du prix
                produitFermier.setPrix(0);
                //retrait de la vente
                productSell.remove(produitFermier);
            } catch (NotEnoughCapacityException e) {
                e.printStackTrace();
            }
        }
        else throw new NotEnoughMoneyException();

        menu.start();
    }

    public void displayMarketListing() {
        System.out.println("########################");
        System.out.println("#####Offre de vente#####");
        System.out.println("########################");

        int index = 0;
        for (ProduitFermier produitFermier : productSell) {
            System.out.println(index+") " + produitFermier.getName());
            System.out.println("#Quantité : " + produitFermier.getAmount());

        }

        System.out.println("x)menu principal");
    }

    public void displayParticipantsStock() {
        int index = 0;

        for (Acheteur acheteur : participants) {
            System.out.println(index +") " + acheteur.getPseudo());
            System.out.println("#Stock : ");
            for (ProduitFermier produitFermier : acheteur.getStock()) {
                System.out.println("-" + produitFermier.getName() + " : " + produitFermier.getAmount());
            }
            ++index;
        }
    }

    public void displayParticipantsMoney() {
        int index = 0;

        for (Acheteur acheteur : participants) {
            System.out.println(index +") " + acheteur.getPseudo());
            System.out.println("#argent : " + acheteur.getArgent());
            ++index;
        }
    }

    private void validateWaitingProduct() {
        List<ProduitFermier> waitingListCopy = new ArrayList<>();
        waitingListCopy.addAll(waitingValidationProduct);

        for (ProduitFermier produitFermier : waitingListCopy) {
            if (produitFermier.isValide()) {
                productSell.add(produitFermier);
                waitingValidationProduct.remove(produitFermier);
            }
        }
    }

    private void product() {
        for (Acheteur acheteur : participants) {
            if (acheteur instanceof Producteur) {
                Producteur producteur = (Producteur) acheteur;
                producteur.produire();
            }
        }
    }

    public List<ProduitFermier> getProductSell() {
        return productSell;
    }

    public void setParticipants(List<Acheteur> participants) {
        this.participants = participants;
    }

    public Trader getTrader() {
        return trader;
    }

    public double getProductTaxe(double prix){
        return prix * (taxe/100);
    }
}
