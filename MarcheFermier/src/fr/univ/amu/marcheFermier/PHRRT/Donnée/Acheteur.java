package fr.univ.amu.marcheFermier.PHRRT.Donnée;

import fr.univ.amu.marcheFermier.PHRRT.Exception.NotEnoughtMoneyException;

public class Acheteur {

    private double money;
    private String pseudo;

    public Acheteur(double money, String pseudo) {
        this.money = money;
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }




    public double getMoney() {
        return money;
    }
    public void retirerArgent(Double budget) throws NotEnoughtMoneyException{

        if(budget>money){
            throw new NotEnoughtMoneyException();
        }
        money -= budget;

    }
}

