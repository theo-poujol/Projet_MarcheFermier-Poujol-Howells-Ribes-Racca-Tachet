package fr.univ.amu.marcheFermier.PHRRT.marche.affichage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static fr.univ.amu.marcheFermier.PHRRT.marche.affichage.Menu.setPrimaryStage;

public class Catalogue extends Application implements Initializable {
    private static Stage primStage;
    private BorderPane root = new BorderPane();
    private VBox vbox = new VBox();
    private Scene scene = new Scene(root);
    private Button cata = new Button("catalogue");
    private Button cot = new Button("cotation");
    private Button journ = new Button("journal");
    private Button partic = new Button("participants");

    public static void setPrimaryStage(Stage stage) {
        primStage = stage;
        primStage.setResizable(false);
    }

    public static Stage getPrimaryStage() {
        return primStage;
    }

    public BorderPane getRoot() {
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        primaryStage.setHeight(700); // juste un choix arbitraire pour avoir une image réaliste de la taille de l'application.
        primaryStage.setWidth(1000);
        setButtonsSize(primaryStage);
        setButtons();
        setOnAction();
        primaryStage.setTitle("Catalogue");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Scene getScene() {
        return scene;
    }

    public void setButtonsSize(Stage primaryStage) {
        cata.setPrefSize( primaryStage.getWidth()/7, primaryStage.getHeight()/4);
        cot.setPrefSize(primaryStage.getWidth()/7, primaryStage.getHeight()/4);
        journ.setPrefSize(primaryStage.getWidth()/7,primaryStage.getHeight()/4);
        partic.setPrefSize(primaryStage.getWidth()/7, primaryStage.getHeight()/4);
    }


    public void setButtons() {
        vbox.getChildren().addAll(cot, journ,cata,partic);
        root.setStyle("-fx-background-color: white");
        root.setLeft(vbox);
    }

    public void setOnAction() {
        cata.setOnAction(event -> {
            Catalogue catalogue = new Catalogue();
            try {
                catalogue.start(primStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        cot.setOnAction(event -> {
            Cotation cotation = new Cotation();
            try {
                cotation.start(primStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        journ.setOnAction(event -> {
            JournalDeTrans journalDeTrans = new JournalDeTrans();
            try {
                journalDeTrans.start(primStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        partic.setOnAction(event -> {
            Participantsvue participantsvue = new Participantsvue();
            try {
                participantsvue.start(primStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
