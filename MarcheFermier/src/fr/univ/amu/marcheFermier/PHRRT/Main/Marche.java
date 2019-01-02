package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitApiculture;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitBio;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitLaitier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Controleur;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Menu;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.List;

public class Marche {
    private String region;
    private Menu menu;
    private List<ProduitFermier> productSell;
    private List<ProduitFermier> waitingValidationProduct;
    private List<Acheteur> participants;
    private LivreMarche livreMarche; // à remplir après chaque transaction
    private Controleur amf; //unique par région
    private int taxe;





    public Marche(String region, int taxe) {
        this.region = region;
        this.taxe = taxe;

        this.menu = new Menu(this);

        this.amf = Controleur.getInstance();
    }


    public void start() {
        //starting
        System.out.println("Starting market in " + region + "...");

        //affichage du menu
        menu.start();
    }

    public List<ProduitFermier> getProductSell() {
        return productSell;
    }

    public List<ProduitFermier> getWaitingValidationProduct() {
        return waitingValidationProduct;
    }

    public void iteration() {
        //validation waitingproduct

    }

    public List<Acheteur> getParticipants() {
        return participants;
    }

    public Controleur getAmf() {
        return amf;
    }

    public void sell(Acheteur acheteur, int indexProduit) {

        ProduitFermier produitFermier = acheteur.getStock().get(indexProduit);

        int price = menu.menuSellerProduct(produitFermier);

        acheteur.getStock().remove(produitFermier);

        produitFermier.setPrix(price);

        productSell.add(produitFermier);
    }
}
