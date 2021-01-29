package dev.yukie.handball.presentation;

import javafx.fxml.FXML;
import dev.yukie.handball.logic.Model;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class KampregisteringsprogramController {

    @FXML
    private Label hold;
    @FXML
    private Label kampe;
    @FXML
    private Label stilling;
    @FXML
    private ListView<String> holdList;
    @FXML
    private ListView<String> kampeList;
    @FXML
    private ListView<String> stillingList;
    @FXML
    private Button opretHold;
    @FXML
    private Button opretKamp;

    @FXML
    private void handleOpretHold(ActionEvent e) {
        App.popupStage.setScene(App.sceneOpretHold);
        App.popupStage.setTitle("Opret Hold");
        App.popupStage.showAndWait();
    }

    @FXML
    private void handleOpretKamp() {
        App.popupStage.setScene(App.sceneOpretKamp);
        App.popupStage.setTitle("Opret Kamp");
        App.popupStage.showAndWait();
    }

    public void initialize() {
        holdList.setItems(Model.getObservableList("hold"));
        kampeList.setItems(Model.getObservableList("kampe"));
        stillingList.setItems(Model.getObservableList("stilling"));
        kampeList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableStrings, String oldString,
                    String newString) {
                if (Model.hasRegistreringer(newString)) {
                    App.popupStage.setScene(App.sceneKamprapport);
                    App.popupStage.setTitle("Kamprapport for " + newString);
                    App.popupStage.showAndWait();
                } else {
                    App.popupStage.setScene(App.sceneRegistrerKamp);
                    App.popupStage.setTitle("Registrer kamp for " + newString);
                    App.popupStage.showAndWait();
                }
            }
        });
    }
}