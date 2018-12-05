package fr.univ.amu.marcheFermier.PHRRT.Graphique;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class vueParticipantsController {

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("vueParticipants.fxml"));

        Scene scene = new Scene(root, 1368, 760);

        stage.setTitle("Marché Fermier");
        stage.setScene(scene);
        stage.show();
    }
}
