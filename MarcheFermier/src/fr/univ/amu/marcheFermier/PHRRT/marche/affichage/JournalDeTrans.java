package fr.univ.amu.marcheFermier.PHRRT.marche.affichage;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static fr.univ.amu.marcheFermier.PHRRT.marche.affichage.Menu.setPrimaryStage;


public class JournalDeTrans extends Application implements Initializable {

    private static Stage primStage;
    private BorderPane root2 = new BorderPane();
    private VBox vbox = new VBox();
    private Scene scene = new Scene(root2);
    private HBox hbox = new HBox();
    private Button test1 = new Button("salut");
    private Menu menu = new Menu();


    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        primaryStage.setHeight(700); // juste un choix arbitraire pour avoir une image réaliste de la taille de l'application.
        primaryStage.setWidth(1000);
        setButtonsSize(primaryStage);
        primaryStage.setTitle("projet fermier");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void setPrimStage(Stage primStage) {
        JournalDeTrans.primStage = primStage;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
        menu.getRoot();
        menu.getScene();
    }

    private void setButtonsSize(Stage primaryStage) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
