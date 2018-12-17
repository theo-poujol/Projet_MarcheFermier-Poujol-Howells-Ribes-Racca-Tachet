package fr.univ.amu.marcheFermier.PHRRT.marche.affichage;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu extends Application {

    private static Stage primStage;
    private BorderPane root = new BorderPane();
    private VBox vbox = new VBox();
    private Scene scene = new Scene(root);
    private HBox hbox = new HBox();
    private Button test1 = new Button();
    private Button test2 = new Button();
    private Button test3 = new Button();
    private Button test4 = new Button("Informations");

    public static void setPrimaryStage(Stage stage) {
        primStage = stage;
        primStage.setResizable(false);
    }

    public static Stage getPrimaryStage() {
        return primStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        primaryStage.setHeight(700); // juste un choix arbitraire pour avoir une image réaliste de la taille de l'application.
        primaryStage.setWidth(480);
        setButtonsSize(primaryStage);
        setButtons();
        setOnAction();
        primaryStage.setTitle("projet fermier");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void setButtonsSize(Stage primaryStage) {
        test1.setPrefSize(primaryStage.getWidth(), 105);
        test2.setPrefSize(primaryStage.getWidth() / 2, 330);
        test3.setPrefSize(primaryStage.getWidth() / 2, 330);
        test4.setPrefSize(primaryStage.getWidth(), 105);
    }


    public void setButtons() {
        hbox.getChildren().addAll();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll();
        root.setStyle("-fx-background-color: white");
        root.setTop(vbox);
        root.setCenter(hbox);
        root.setBottom(test1);
    }

    public void setOnAction() {

    }

}
