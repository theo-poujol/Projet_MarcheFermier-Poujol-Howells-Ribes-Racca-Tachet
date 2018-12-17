package fr.univ.amu.marcheFermier.PHRRT.marche.affichage;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Test extends Application implements Initializable {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlFiles/test.fxml"));

        VBox root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("projet fermier");
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
