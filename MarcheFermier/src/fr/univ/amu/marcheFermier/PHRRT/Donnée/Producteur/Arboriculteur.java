package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Cerisier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.Olivier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotENoughtCapacityException;

import java.time.LocalDate;

public class Arboriculteur extends Producteur {
    private Producteur producteurADecorer; // à modifier

    public Arboriculteur(Producteur producteurADecorer) {
        super(producteurADecorer.getMoney(),producteurADecorer.getPseudo());
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();

        //production olivier
        ProduitFermier olivier = new Olivier(LocalDate.now(),1,this);

        //production cerisier
        ProduitFermier cerisier = new Cerisier(LocalDate.now(),1,this);

        try {
            producteurADecorer.addProduit(olivier);
            producteurADecorer.addProduit(cerisier);

        } catch (NotENoughtCapacityException e) {
            e.printStackTrace();
        }

    }
}
