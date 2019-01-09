package Test;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Apiculteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Miel;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitApiculture;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.Transaction;
import fr.univ.amu.marcheFermier.PHRRT.Main.LivreMarche;
import fr.univ.amu.marcheFermier.PHRRT.Main.Marche;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LivreMarcheTest {
    private Marche marche = new Marche("Languedoc", 10);
    private Producteur prod = new Apiculteur(new Producteur(300, "producteur"));
    private LivreMarche livre = new LivreMarche();


    @Test
    void addTransaction() {
        ProduitApiculture produit = new Miel(LocalDate.now(), 10, prod);

        Transaction transaction = new Transaction(prod, produit, 1);
        livre.addTransaction(transaction);
        if (livre.getMesTransactions().isEmpty()) {
            fail("pas de transaction");
        }

    }
}
