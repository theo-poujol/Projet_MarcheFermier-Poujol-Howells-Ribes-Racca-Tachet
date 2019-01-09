package Test;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Miel;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitArboricole;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Ordre;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.OrdreTrader;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Trader;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;
import fr.univ.amu.marcheFermier.PHRRT.Main.Marche;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Controleur;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TraderTest {

    @Test
    void addOrder() {
        Marche marcheTest = new Marche("france",10);
        Trader traderTest = new Trader(marcheTest,"marcheTest");
        Acheteur acheteur = new Acheteur(150,"pseudo");
        OrdreTrader ordreTest = new OrdreTrader("test",2,acheteur,1);
        traderTest.addOrder(ordreTest);
        if (traderTest.getOrdres().isEmpty()){
            fail("tableau vide");
        }
    }

    @Test
    void checkMarket() {
        Marche marcheTest = new Marche("france",10);
        Trader traderTest = new Trader(marcheTest,"marcheTest");
        Acheteur acheteur = new Acheteur(1500,"acheteur");
        Acheteur vendeur = new Acheteur(1500,"vendeur");
        ProduitFermier produitTest = new Miel(LocalDate.now(),10,vendeur);

        OrdreTrader ordreTest = new OrdreTrader(produitTest.getName(),10,acheteur,100);
        traderTest.addOrder(ordreTest);
        marcheTest.addTrader(traderTest);
        try {
            vendeur.addProduit(produitTest);
        } catch (NotEnoughCapacityException e) {
            e.printStackTrace();
        }
        marcheTest.sell(vendeur,produitTest,100);

        marcheTest.getWaitingValidationProduct().get(0).valider();

        marcheTest.validateWaitingProduct();


        try {
            traderTest.checkMarket();
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }

        if (acheteur.getStock().isEmpty() ){
            fail();
        }
    }

    @Test
    void addClient() {
        Marche marcheTest = new Marche("france",10);
        Trader traderTest = new Trader(marcheTest,"marcheTest");
        Acheteur acheteur = new Acheteur(1500,"acheteur");
        traderTest.addClient(acheteur);
        if (traderTest.getClients().isEmpty()){
            fail();
        }
    }
}