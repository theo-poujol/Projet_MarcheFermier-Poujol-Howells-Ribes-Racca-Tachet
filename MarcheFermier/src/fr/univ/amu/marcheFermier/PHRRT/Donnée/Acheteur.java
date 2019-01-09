package fr.univ.amu.marcheFermier.PHRRT.Donnée;


import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughtMoneyException;

import java.util.ArrayList;
import java.util.List;

public class Acheteur {


    private List<ProduitFermier> stock = new ArrayList<>();
    private double money;
    private String pseudo;

    public void setMoney(double money) {
        this.money = money;
    }

    public Acheteur(double money, String pseudo) {
        this.money = money;
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }




    public  List<ProduitFermier> getStock() {
        return stock;
    }
    public double getMoney() {
        return money;
    }
    public void retirerArgent(Double budget) throws NotEnoughtMoneyException {

        if(budget>money){
            throw new NotEnoughtMoneyException();
        }
        money -= budget;

    }
}

