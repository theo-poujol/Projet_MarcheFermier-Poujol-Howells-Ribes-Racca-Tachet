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


    private ArrayList<ProduitFermier> sellProducts = new ArrayList<>();


    public Grossiste(double money, String pseudo) {
        super(money, pseudo);
    }



    // Solution pour palier au problème de grosse quantité, lorsque l'on veut vendre seulement une partie d'un gros stock de quantité
    // On crée donc un nouveau ProduitEncheres qui est un ProduitFermier. On a donc deux produits différents car ils different de leur quantité
    // On a donc le ProduitFermier au quel on a enlevé la quantité mise en vente voulue
    // Et le ProduitEnchere qui est aux enchères avec la quantité voulue.

    public void sellMyProduct(ProduitFermier product,double price, int cap) {

        try {
            for (ProduitFermier p : sellProducts) {
                if (sellProducts.contains(product)) {
                    if (product.getAmount() < cap) throw new NotEnoughCapacityException(); // Exception sur la quantité
                    if (price==0) throw new NullPriceException();
                    else {

                        ProduitEncheres pe = new ProduitEncheres(product,cap);
                        pe.setPrix(price * cap);
                        PropositionVente pv = new PropositionVente(this,pe,pe.getAmount());
                        // Quand on créée une nouvelle PV on doit l'ajouter automatiquement dans la liste des pv du marche
                        product.setAmount(product.getAmount() - cap);
                        if (product.getAmount() == 0) this.removeFromList(product);
                        System.out.println("cest bon");
                    }
                }
                else throw new NotFoundException();
            }
        }
        catch (NotEnoughCapacityException e) {e.getMessage();}
        catch (NotFoundException e) {e.getMessage();}
        catch (NullPriceException e) {e.getMessage();}Ò
    }

    public void buyProduct(Marche market,ProduitEncheres p) throws NotEnoughtMoneyException {
        if (market.isPresent(p)) {
            for (PropositionVente pv : market.getLesPropositionsVentes()) {
                if(pv.getMonProduit().equals(p)) {
                    this.retirerArgent(p.getPrix());
                    p.getProprietaire().setMoney(p.getProprietaire().getMoney() + p.getPrix());
                    p.setProprietaire(this);
                    this.addToMyList(p);
                }
            }
        }
    }

    public void immediateBuy() {} // Proposer au client de vendre immédiatement son produit à prix réduit à un grossite selon ce que les objets que recherche le grossite



    public void addToMyList(ProduitFermier p) {
        sellProducts.add(p);
    }

    public void removeFromList(ProduitFermier p){
        sellProducts.remove(p);
    }

    public ArrayList<ProduitFermier> getSellProducts() {

        for(ProduitFermier p : sellProducts) {
            System.out.println(p.getName());
            System.out.println(p.getAmount());

        }
        return sellProducts;
    }

    public void setSellProducts(ArrayList<ProduitFermier> sellProducts) {
        this.sellProducts = sellProducts;
    }



}
