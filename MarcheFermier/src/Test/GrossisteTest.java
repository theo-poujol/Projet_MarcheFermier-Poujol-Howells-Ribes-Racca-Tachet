package Test;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste.Grossiste;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Reblochon;
import fr.univ.amu.marcheFermier.PHRRT.Main.Marche;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

class GrossisteTest {

    Grossiste acheteur = new Grossiste(1000,"Axel");
    Grossiste vendeur  = new Grossiste(2000,"Samos");
    ProduitFermier produit1 = new Reblochon(LocalDate.now(),200,vendeur);
    Marche marche = new Marche("Savoie",10);

    ProduitFermier produit2;
    ProduitFermier produit3;
    ArrayList<ProduitFermier> nouveauStockTest = new ArrayList<ProduitFermier>();



    @Test
    void testSellMyProduct() {
        vendeur.sellMyProduct(marche,produit1,10,10);

    }

    @Test
    void testBuyProduct() {
        acheteur.buyProduct(marche,produit1.getName(),5,produit1.getProprietaire());
    }

    @Test
    void testAddToMyList() {
        System.out.println('\n' + "Ajout de " + produit1.getAmount() + ' ' + produit1.getName() + " à " + vendeur.getPseudo() + '\n');
        vendeur.addToMyList(produit1);
        System.out.println("Produit ajouté");
        System.out.println('\n' + "----- Après ajout -----" + '\n');
        vendeur.showMyInformation();
    }

    @Test
    void testRemoveFromList() {
        vendeur.removeFromList(produit1);
    }

    @Test
    void testShowMyInformation() {
        acheteur.showMyInformation();
        System.out.println('\n');
        vendeur.showMyInformation();
    }

    @Test
    void testGetSellProducts() {
        acheteur.getSellProducts();
        vendeur.getSellProducts();


    }

    @Test
    void testSetSellProducts() {
        nouveauStockTest.add(produit2);
        nouveauStockTest.add(produit3);
        vendeur.setSellProducts(nouveauStockTest);
    }
}