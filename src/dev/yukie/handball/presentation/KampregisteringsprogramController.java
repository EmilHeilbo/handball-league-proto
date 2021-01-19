package dev.yukie.handball.presentation;

import javafx.fxml.FXML;
import dev.yukie.handball.logic.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class KampregisteringsprogramController {
    
    @FXML private Label hold;
    @FXML private ListView<String> holdList;

    @FXML
    private void handleOpretHold(ActionEvent e){
        holdList.getItems().clear();
        holdList.getItems().addAll(Model.getHold());
        Model.addHold("Test");
    }

}