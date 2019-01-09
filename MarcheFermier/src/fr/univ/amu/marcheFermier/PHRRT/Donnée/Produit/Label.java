package fr.univ.amu.marcheFermier.PHRRT.Donnée.Produit;

public class Label {
    private String title;
    private String description;

    /**
     * Constructeur Label.
     *
     * @param title
     * @param description
     */
    public Label(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     * Getter qui retourne un titre.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter qui retourne une description.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
