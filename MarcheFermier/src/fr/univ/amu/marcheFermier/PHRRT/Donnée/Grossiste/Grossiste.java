package fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste;


import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitEncheres;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughtMoneyException;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotFoundException;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NullPriceException;
import fr.univ.amu.marcheFermier.PHRRT.Main.Marche;

import java.util.ArrayList;

public class Grossiste extends Acheteur {



    public ArrayList<ProduitFermier> getSellProducts() {
        return sellProducts;
    }

    private ArrayList<ProduitFermier> sellProducts = new ArrayList<>();



    public Grossiste(double money, String pseudo) {
        super(money, pseudo);
    }



    // Solution pour palier au problème de grosse quantité, lorsque l'on veut vendre seulement une partie d'un gros stock de quantité
    // On crée donc un nouveau ProduitEncheres qui est un ProduitFermier. On a donc deux produits différents car ils different de leur quantité
    // On a donc le ProduitFermier au quel on a enlevé la quantité mise en vente voulue
    // Et le ProduitEnchere qui est aux enchères avec la quantité voulue.
    // price est le prix à l'UNITE

    public void sellMyProduct(Marche market, ProduitFermier product, double price, int cap) {

        try {
            if (sellProducts.contains(product)) {
                if (product.getAmount() < cap) throw new NotEnoughCapacityException(); // Exception sur la quantité
                    if (price==0) throw new NullPriceException();
                    else {

                        ProduitEncheres pe = new ProduitEncheres(product,cap);
                        // prix à l'unité multiplié par la quantité
                        pe.setPrix(price * cap);
                        PropositionVente pv = new PropositionVente(this,pe,pe.getAmount());

                        product.setAmount(product.getAmount() - cap);
                        if (product.getAmount() == 0) this.removeFromList(product);

                        market.addSale(pv);
                        // AJOUTER AUSSI ICI L'AJOUT A LHISTORIQUE DU MARCHE
                        // Quand on créée une nouvelle PV on doit l'ajouter automatiquement dans la liste des pv du marche
                        System.out.println( this.getPseudo() + " a mit en vente "+ pe.getAmount() + ' ' + pe.getName() + " pour " + pe.getPrix() + " € " + "en " + market.getRegion());
                    }
                }
                else throw new NotFoundException();

        }
        catch (NotEnoughCapacityException e) {e.getMessage();}
        catch (NotFoundException e) {e.getMessage();}
        catch (NullPriceException e) {e.getMessage();}
    }




    public void buyProduct (Marche market,String s, int cap, Acheteur proprietaire){

        try {
            for (PropositionVente pv : market.getLesPropositionsVentes()) {

                if (pv.getMonProduit().getName() == s && pv.getMonProduit().getProprietaire().equals(proprietaire)) {
                    System.out.println("OUIENFIN");

                    if (pv.getMonProduit().getAmount() == cap) {
                        if (this.getMoney() < pv.getMonProduit().getPrix()) throw new NotEnoughtMoneyException();
                        double prix = pv.getMonProduit().getPrix();
                        this.retirerArgent(pv.getMonProduit().getPrix());
                        proprietaire.setMoney(proprietaire.getMoney() + pv.getMonProduit().getPrix());
                        pv.getMonProduit().setProprietaire(this);
                        this.addToMyList(pv.getMonProduit());
                        market.removeSale(pv);
                        System.out.println(this.getPseudo() + " a acheté " + pv.getMonProduit().getName() + " au vendeur " +
                        pv.getMonProduit().getProprietaire().getPseudo() + " pour " + prix + '€'
                        + " et supprimé du marché car quantité écoulée");

                    }


                    if (pv.getMonProduit().getAmount() > cap) {
                        if (((cap * pv.getMonProduit().getPrix()) / pv.getMonProduit().getAmount()) > this.getMoney())
                            throw new NotEnoughtMoneyException();
                        // Produit en croix pour avoir le nouveau prix, car celui de base
                        // est proportionnel à la quantité
                        double prix = (cap * pv.getMonProduit().getPrix()) / pv.getMonProduit().getAmount();
                        this.retirerArgent(prix);
                        pv.getMonProduit().setPrix(((pv.getMonProduit().getAmount() - cap) * pv.getMonProduit().getPrix()) / pv.getMonProduit().getAmount());
                        pv.getMonProduit().setAmount(pv.getMonProduit().getAmount() - cap);
                        ProduitFermier nouveauProduit = new ProduitEncheres(pv.getMonProduit(), cap);
                        nouveauProduit.setProprietaire(this);
                        this.addToMyList(nouveauProduit);
                        System.out.println(this.getPseudo() + " a acheté " + nouveauProduit.getName() + " au vendeur " +
                        pv.getMonProduit().getProprietaire().getPseudo() + " pour " + prix + '€' );

                    }

                }

            }
        }

        catch(NotEnoughtMoneyException e) {e.getMessage();}
    }











    public void addToMyList(ProduitFermier p) {
        sellProducts.add(p);
    }

    public void removeFromList(ProduitFermier p){
        sellProducts.remove(p);
    }

    public void showMyInformation() {
        System.out.println("---------------------");
        System.out.println(
                "Nom    : " + this.getPseudo() + '\n'  +
                "Argent : " + this.getMoney()  + " €"  + '\n'  +
                "Stock  : ");

        for(ProduitFermier p : sellProducts) {
            System.out.println(p.getName() + " " + p.getAmount());
        }
        System.out.println("---------------------");
    }


    public void setSellProducts(ArrayList<ProduitFermier> sellProducts) {
        this.sellProducts = sellProducts;
    }
}
