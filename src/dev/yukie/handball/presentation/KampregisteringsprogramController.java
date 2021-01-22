package dev.yukie.handball.presentation;

import javafx.fxml.FXML;
import dev.yukie.handball.logic.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KampregisteringsprogramController implements Initializable {
    
    @FXML private Label hold;
    @FXML private ListView<String> holdList;
    @FXML private Button opretHold;
    @FXML private Button opretKamp;
    @FXML private Label kampe;
    @FXML private ListView<Integer> kampeList;
    @FXML private Label stilling;


    @FXML
    private void handleOpretHold(ActionEvent e){
        holdList.getItems().clear();
        holdList.getItems().addAll(Model.getHold());
        Model.addHold("Test");
    }
    @FXML
    private void handleOpretKamp() {
        kampeList.getItems().clear();
        kampeList.getItems().addAll(Model.getKampe().add(1,2));
        Model.addHold("Test");
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("OpretKamp.fxml"));

            OpretKampController opretKampController = (OpretKampController) loader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("OpretKamp");
            userStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}