package Test;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.ProducteurDeViande;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.ProducteurLaitier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProducteurTest {

    @Test
    void produire() {
        Producteur producteur = new ProducteurDeViande(new ProducteurLaitier(new Producteur(200,"loris")));
        producteur.produire();
        if (producteur.getStock().size() <= 0) {
            fail();
        }
    }

    @Test
    void addProduit() {
        Producteur producteur = new ProducteurDeViande(new ProducteurLaitier(new Producteur(200,"loris")));
        try {
            producteur.addProduit(new ProduitFermier(LocalDate.now(),"ok",10,producteur));
        } catch (NotEnoughCapacityException e) {
            e.printStackTrace();
            fail();
        }
        if (producteur.getStock().size() <= 0) {
            fail();
        }
    }
}