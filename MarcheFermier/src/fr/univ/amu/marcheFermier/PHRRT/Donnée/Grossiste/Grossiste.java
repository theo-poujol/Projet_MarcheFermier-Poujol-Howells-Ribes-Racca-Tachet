package fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste;


import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitEncheres;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Trade.PropositionVente;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotFoundException;
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

    public void sellMyProduct(ProduitFermier product, int cap) {

        try {
            for (ProduitFermier p : sellProducts) {
                if (sellProducts.contains(product)) {
                    if (product.getAmount() < cap) throw new NotEnoughCapacityException(); // Exception sur la quantité
                    else {
                        ProduitEncheres pe = new ProduitEncheres(product,cap);
                        pe.setPrix(p.getPrix() * cap);
                        PropositionVente pv = new PropositionVente(this,pe,pe.getAmount());
                        product.setAmount(product.getAmount() - cap);
                        System.out.println("cest bon");
                    }
                }
                else throw new NotFoundException();
            }
        }
        catch (NotEnoughCapacityException e) {e.getMessage();}
        catch (NotFoundException e) {e.getMessage();}
    }

    public void buyProduct() {

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
