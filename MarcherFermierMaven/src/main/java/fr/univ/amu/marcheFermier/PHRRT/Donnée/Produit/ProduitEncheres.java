package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

import java.time.LocalDate;


public class ProduitEncheres extends ProduitFermier{


    /**
     * Classe permettante de mettre en vente une certaine capacité d'un produit fermier
     *
     * @param p     : produit fermier à vendre
     * @param cap   : capacité voulue
     */

    public ProduitEncheres(ProduitFermier p, int cap) {
        super(p.getPeremptionDate(), p.getName(), cap, p.getProprietaire());
    }

}
