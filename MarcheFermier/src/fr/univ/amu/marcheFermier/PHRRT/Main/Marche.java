package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.*;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Controleur;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.List;

public class Marche {


    private String region;
    private List<ProduitFermier> lesProduitsFermier = new ArrayList<ProduitFermier>();
    private List<Producteur> lesProducteurs = new ArrayList<Producteur>();
    private LivreMarche livreMarche;
    private List<PropositionVente> lesPropositionsVentes = new ArrayList<PropositionVente>();
    private int etape = 0;
    private Controleur amf;
    private double cotisation = 0.0;

    public Marche(String region) {
        this.region = region;

    }


    public String getRegion() {
        return region;
    }

    public List<PropositionVente> getLesPropositionsVentes() {
        return lesPropositionsVentes;
    }

    public void mesPropositionsVentes() {
        System.out.println('\n' + "Stock en " + this.getRegion() + '\n');
        for (PropositionVente pv : lesPropositionsVentes) {
            System.out.println(pv.getMonProduit().getName() + " " + pv.getMonProduit().getPrix() + " € " + pv.getMonProduit().getAmount() +
            ' ' + pv.getMonProduit().getProprietaire().getPseudo());
        }
    }


    public boolean isPresent(ProduitEncheres p) {
        if (this.lesProduitsFermier.contains(p)) return true;
        else return false;
    }

    public void addSale(PropositionVente pv) {
        this.lesPropositionsVentes.add(pv);
    }

    public void removeSale(PropositionVente pv) {
        this.lesPropositionsVentes.remove(pv);
    }


}
