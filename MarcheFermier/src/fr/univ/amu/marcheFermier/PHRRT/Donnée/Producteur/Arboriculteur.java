package fr.univ.amu.marcheFermier.PHRRT.Donnée.Producteur;

<<<<<<< HEAD
public class Arboriculteur extends Producteur{
    public Arboriculteur(double money, String pseudo) {
        super(money, pseudo);
=======
public class Arboriculteur extends Producteur {
    private Producteur producteurADecorer; // à modifier

    public Arboriculteur(Producteur producteurADecorer) {
        this.producteurADecorer = producteurADecorer;
    }

    @Override
    public void produire() {
        producteurADecorer.produire();
        System.out.println("je produis des arbres");
>>>>>>> origin/produitProducteur
    }
}
