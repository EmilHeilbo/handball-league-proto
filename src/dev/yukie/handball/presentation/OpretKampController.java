package dev.yukie.handball.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import dev.yukie.handball.logic.Model;
import javafx.event.ActionEvent;

public class OpretKampController {

    @FXML
    private ChoiceBox<String> hjemmebox;
    @FXML
    private ChoiceBox<String> udebox;

    @FXML
    private void handleAnullere(ActionEvent e) {
        App.popupStage.close();
    }

    @FXML
    private void opretKamp(ActionEvent e) {
        if (Model.addKamp(hjemmebox.getValue(), udebox.getValue())) {
            handleAnullere(e);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Fejlmeddelelse");
            alert.setHeaderText("Kampen kan ikke oprettes");
            alert.setContentText("Undersøg om kampen allerede eksistere.\nEt hold kan ikke spille mod sig selv.\nHvis du prøver at oprettet en kamp, med et nyt hold\n, skal programmet genstartes.");
            alert.showAndWait();
        }
    }

    public void initialize() {
        hjemmebox.setItems(Model.getObservableList("hold"));
        udebox.setItems(Model.getObservableList("hold"));
    }

}