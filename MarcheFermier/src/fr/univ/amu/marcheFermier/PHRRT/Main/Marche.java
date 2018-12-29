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
    private List<ProduitFermier> lesProduitsFermier;
    private List<Producteur> lesProducteurs;
    private LivreMarche livreMarche;



    private List<PropositionVente> lesPropositionsVentes;
    private int etape;
    private Controleur amf;
    private int cotisation;


    public Marche(String region, List<ProduitFermier> lesProduitsFermier, List<Producteur> lesProducteurs, LivreMarche livreMarche, List<PropositionVente> lesPropositionsVentes, int etape, Controleur amf, int cotisation) {
        this.region = region;
        this.lesProduitsFermier = lesProduitsFermier;
        this.lesProducteurs = lesProducteurs;
        this.livreMarche = livreMarche;
        this.lesPropositionsVentes = lesPropositionsVentes;
        this.etape = etape;
        this.amf = amf;
        this.cotisation = cotisation;
    }


    public List<PropositionVente> getLesPropositionsVentes() {
        return lesPropositionsVentes;
    }


    public boolean isPresent(ProduitEncheres p) {
        if (this.lesProducteurs.contains(p)) return true;
        else return false;
    }


}
