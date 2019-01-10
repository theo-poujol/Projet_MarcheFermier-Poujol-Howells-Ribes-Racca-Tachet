package Test;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Miel;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Controleur;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControleurTest {

    @Test
    void choisirAcheteur() {

    }

    @Test
    void inspecter() {

    }

    @Test
    void valider() {
        Acheteur acheteur = new Acheteur(200,"loris");
        ProduitFermier produitFermier = new Miel(LocalDate.now(),10, acheteur);

        Controleur controleur = Controleur.getInstance();

        controleur.valider(produitFermier);

        if (!produitFermier.isValide()) {
            fail("le produit n'est pas valide");
        }
    }
}