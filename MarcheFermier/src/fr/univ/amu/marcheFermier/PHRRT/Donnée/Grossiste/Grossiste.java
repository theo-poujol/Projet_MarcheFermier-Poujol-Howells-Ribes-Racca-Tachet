package fr.univ.amu.marcheFermier.PHRRT.Donnée.Grossiste;


import fr.univ.amu.marcheFermier.PHRRT.Donnée.Acheteur;
import fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit.ProduitFermier;
import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughtMoneyException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Grossiste  {

    private String name;
    private String specialty;
    private ArrayList<ProduitFermier> sellProducts = new ArrayList<>();
    private double budget = 0.0;


    public void getMoneyFromClient(Acheteur buyer, double money) {
        try {

            if (buyer.getMoney() == 0) throw new NotEnoughtMoneyException();

            buyer.retirerArgent(money);
            this.budget += money;
        }

        catch(NotEnoughtMoneyException ne){
            ne.printStackTrace();
        }
    }

    public void buyProduct(ProduitFermier product) {
        product.getProprietaire().setMoney( product.getProprietaire().getMoney());
    }


    public Grossiste(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public ArrayList<ProduitFermier> getSellProducts() {
        return sellProducts;
    }

    public void setSellProducts(ArrayList<ProduitFermier> sellProducts) {
        this.sellProducts = sellProducts;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
