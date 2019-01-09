package Test;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste.Grossiste;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Reblochon;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Transaction;
import fr.univ.amu.marcheFermier.PHRRT.Main.Marche;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

class GrossisteTest {

    Grossiste acheteur = new Grossiste(10000,"Axel");
    Grossiste vendeur  = new Grossiste(20000,"Samos");
    ProduitFermier produit1 = new Reblochon(LocalDate.now(),200,vendeur);
    Marche marche = new Marche("Savoie",10);

    ProduitFermier produit2;
    ProduitFermier produit3;
    ArrayList<ProduitFermier> nouveauStockTest = new ArrayList<ProduitFermier>();




    @Test
    void testSellMyProduct() {
        vendeur.addToMyList(produit1);
        vendeur.sellMyProduct(marche,produit1,10,9);
        marche.displayMarketListing();

        if (!(marche.getProductSell().contains(produit1))) {
            fail ("produit non ajouté au marché");
        }



    }

    @Test
    void testBuyProduct() {
        acheteur.buyProduct(marche,produit1.getName(),5,produit1.getProprietaire());
        System.out.printf(produit1.getName());
        acheteur.showMyInformation();
        }


    @Test
    void testAddToMyList() {
        System.out.println('\n' + "Ajout de " + produit1.getAmount() + ' ' + produit1.getName() + " à " + vendeur.getPseudo() + '\n');
        vendeur.addToMyList(produit1);
        System.out.println("Produit ajouté");
        System.out.println('\n' + "----- Après ajout -----" + '\n');
        vendeur.showMyInformation();
        if (!((vendeur.getSellProducts().contains(produit1)))) {
            fail("non ajouté");
        }
    }

    @Test
    void testRemoveFromList() {
        vendeur.removeFromList(produit1);
        if (vendeur.getSellProducts().contains(produit1)) {
            fail("Non supprimé");
        }
    }

}