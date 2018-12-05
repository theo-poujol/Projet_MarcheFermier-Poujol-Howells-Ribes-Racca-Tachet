package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

public class Label {
    private String title;
    private String description;

    public Label(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
