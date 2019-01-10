package fr.univ.amu.marcheFermier.PHRRT.Donnée;



import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughCapacityException;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughMoneyException;


import java.util.ArrayList;
import java.util.List;

public class Acheteur {


    private List<ProduitFermier> stock = new ArrayList<>();

    public void setMoney(double money) {
        this.money = money;
    }

    private double money;
    private String pseudo;

    /**
     * Constructeur Acheteur.
     *
     * @param money
     * @param pseudo
     */
    public Acheteur(double money, String pseudo) {
        this.money = money;
        this.pseudo = pseudo;
    }

    /**
     * Getter qui retourne le pseudo de l'acheteur.
     *
     * @return pseudo
     */
    public String getPseudo() {
        return pseudo;
    }


    /**
     * Getter qui retourne le stock.
     *
     * @return stock
     */
    public  List<ProduitFermier> getStock() {
        return stock;
    }

    /**
     * Getter qui retourne l'money de l'acheteur.
     *
     * @return argent
     */
    public double getMoney() {
        return money;
    }

    /**
     * Permet de retirer de l'money sur le compte de l'acheteur.
     *
     * @param budget
     * @throws NotEnoughMoneyException
     *              verifie que le client a l'money nécessaire pour acheter le produit.
     */

    public void retirerArgent(Double budget) throws NotEnoughMoneyException {
        money -= budget;


    }

    /**
     * Permet d'ajouter de l'money sur le compte de l'acheteur.
     *
     * @param budget
     * @throws NotEnoughMoneyException
     *              verifie que le client a l'money nécessaire pour acheter le produit.
     */
    public void ajouterArgent(Double budget) {
        money += budget;
    }

    /**
     * Permet l'ajout de produits fermier dans le stock.
     *
     * @param produitFermier
     * @throws NotEnoughCapacityException
     */
    public void addProduit(ProduitFermier produitFermier) throws NotEnoughCapacityException {


        if (!addExistingProduit(produitFermier)) {
            stock.add(produitFermier);
        }
    }

    /**
     * Permet d'ajouter un produit, et de verifier si il existe dejà dans le stock ou non.
     *
     * @param produitFermier
     * @return a boolean
     */
    private boolean addExistingProduit(ProduitFermier produitFermier) {
        //si le produit est deja en possession du producteur
        for (ProduitFermier currentProduit : stock) {
            //si le nom du nouveau produit correspond au nom d'un produit du stock
            if (currentProduit.getName().equalsIgnoreCase(produitFermier.getName())) {
                //on change juste le montant
                int currentAmount = currentProduit.getAmount();
                currentProduit.setAmount(currentAmount + produitFermier.getAmount());
                return true;
            }
        }
        //si le produit n'existe pas dans le stock
        return false;
    }

    /**
     * Permet d'ajouter un certain montant sur le compte de l'acheteur.
     *
     * @param montant
     */
    public void addArgent(double montant) {
        this.money = money + montant;
    }
}

