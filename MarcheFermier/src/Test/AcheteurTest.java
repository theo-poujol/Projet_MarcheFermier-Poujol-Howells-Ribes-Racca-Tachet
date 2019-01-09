package Test;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Apiculteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Miel;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AcheteurTest {

    @Test
    void retirerArgent() {
        Acheteur acheteur = new Acheteur(200,"loris");
        try {
            acheteur.retirerArgent(100.00);
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
            fail("Pas assez d'argent");
        }
        if (acheteur.getMoney() != 100.00) {
            fail("erreur de gestion d'argent");
        }
    }

    @Test
    void ajouterArgent() {
        Acheteur acheteur = new Acheteur(200,"loris");
        acheteur.addArgent(200);
        if (acheteur.getMoney() != 400) {
            fail("erreur de gestion d'argent");
        }
    }

    @Test
    void addProduit() {
        Acheteur prod = new Apiculteur(new Producteur(300,"producteur"));
        Acheteur acheteur = new Acheteur(400,"acheteur");
        ProduitFermier produit = new Miel(LocalDate.now(),10,prod);
        try {
            acheteur.addProduit(produit);
            if (acheteur.getStock().isEmpty()) {
                fail ("le produit n'a pas été ajouté");
            }
        }
        catch (NotEnoughCapacityException e ) {
            e.printStackTrace();
            fail("pas assez de place");
        }


    }

    @Test
    void addArgent() {
        Acheteur acheteur = new Acheteur(400,"acheteur");
        acheteur.addArgent(300);
        if (acheteur.getMoney()!=700)
            fail("l'argent n'a pas été ajouté");

    }
}