package Test;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
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
    }

    @Test
    void ajouterArgent() {
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
            fail();
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