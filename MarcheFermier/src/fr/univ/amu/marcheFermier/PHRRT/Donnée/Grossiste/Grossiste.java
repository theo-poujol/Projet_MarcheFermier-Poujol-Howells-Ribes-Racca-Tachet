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



    private double depenses = 0;
    private double benefice = 0;

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
                        // Quand on créée une nouvelle PV on doit l'ajouter automatiquement dans la liste des pv du marche
                        System.out.println( this.getPseudo() + " a mit en vente " + pe.getName() + " pour " + pe.getPrix() + " € " + "en " + market.getRegion());
                    }
                }
                else throw new NotFoundException();

        }
        catch (NotEnoughCapacityException e) {e.getMessage();}
        catch (NotFoundException e) {e.getMessage();}
        catch (NullPriceException e) {e.getMessage();}
    }


    public void transaction(Acheteur buyer, double price) throws NotEnoughtMoneyException {
        this.retirerArgent(price);

    }


    public void buyProduct2(Marche market,String s,int cap) throws NotEnoughtMoneyException {

            for (PropositionVente pv : market.getLesPropositionsVentes()) {
                ProduitFermier p = pv.getMonProduit();
                if(p.getName() == s) {
                    if (p.getAmount() == cap) {
                        this.retirerArgent(p.getPrix());
                        p.getProprietaire().setMoney(p.getProprietaire().getMoney() + p.getPrix());
                        p.setProprietaire(this);
                        this.addToMyList(p);
                        market.removeSale(pv);
                        System.out.println("Produit " + p.getName() + " acheté et supprimé du marché car quantité écoulée");
                    }

                    if(p.getAmount() < cap) {
                        this.retirerArgent((cap * p.getPrix()) / p.getAmount() );
                        p.setPrix( ((p.getAmount() - cap) * p.getPrix()) / p.getAmount() );
                        p.setAmount( p.getAmount() - cap);
                        ProduitFermier newProduct = new ProduitEncheres(p,cap);
                        newProduct.setProprietaire(this);
                        this.addToMyList(newProduct);
                        System.out.println("Produit " + newProduct.getName() + " acheté en quantité " + newProduct.getAmount());
                    }
                }
            }
    }



    public double getDepenses() {
        return depenses;
    }

    public void setDepenses(double depenses) {
        this.depenses = depenses;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
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
                "Stock : ");

        for(ProduitFermier p : sellProducts) {
            System.out.println(p.getName() + " " + p.getAmount());
        }
        System.out.println("---------------------");
    }


    public void setSellProducts(ArrayList<ProduitFermier> sellProducts) {
        this.sellProducts = sellProducts;
    }
}
