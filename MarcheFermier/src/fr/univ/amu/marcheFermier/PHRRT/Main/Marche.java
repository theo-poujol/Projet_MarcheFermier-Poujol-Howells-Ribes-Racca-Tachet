package fr.univ.amu.marcheFermier.PHRRT.Main;

import fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur.Producteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitApiculture;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitBio;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitLaitier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Traitement.Controleur;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.List;

public class Marche {
    private String region;
    private List<ProduitFermier> lesProduitsFermier;
    private List<Producteur> lesProducteurs;
    private LivreMarche livreMarche; // à remplir après chaque transaction
    private List<PropositionVente> lesPropositionsVentes;
    private int etape; // PropositionVente, Validation, Achat, mise à jour affichage
    private Controleur amf; //unique par région
    private int cotisation;




}
