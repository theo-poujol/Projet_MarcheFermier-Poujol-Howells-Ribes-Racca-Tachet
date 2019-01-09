package Test;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Label;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProduitFermierTest {

    @Test
    void addLabel() {
        Label label = new Label("AOP", "Appelation d'origine controllé");
        Producteur producteur = new Producteur(200,"pseudo");
        ProduitFermier produitFermier = new ProduitFermier(LocalDate.now(),"ok",10,producteur);

        produitFermier.addLabel(label);

        if (produitFermier.getLabels().size() <= 0) {
            fail();
        }
    }

    @Test
    void isBio() {
        Producteur producteur = new Producteur(200,"pseudo");
        ProduitFermier produitFermier = new ProduitFermier(LocalDate.now(),"ok",10,producteur);
        produitFermier.setBio(true);

        if (!produitFermier.isBio()) {
            fail();
        }
    }

    @Test
    void isValide() {
        Producteur producteur = new Producteur(200,"pseudo");
        ProduitFermier produitFermier = new ProduitFermier(LocalDate.now(),"ok",10,producteur);
        produitFermier.valider();

        if (!produitFermier.isValide()) {
            fail();
        }
    }

    @Test
    void valider() {
        Producteur producteur = new Producteur(200,"pseudo");
        ProduitFermier produitFermier = new ProduitFermier(LocalDate.now(),"ok",10,producteur);
        produitFermier.valider();

        if (!produitFermier.isValide()) {
            fail();
        }
    }
}