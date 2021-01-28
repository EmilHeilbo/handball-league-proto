package dev.yukie.handball.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import dev.yukie.handball.logic.Model;
import javafx.event.ActionEvent;
public class OpretHoldController {

    @FXML private TextField holdtext;

    @FXML
    private void handleAnullere(ActionEvent e){
        holdtext.clear();
        App.popupStage.close();
    }

    @FXML
    private void opretHold(ActionEvent e){
        if(Model.addHold(holdtext.getText())) {
            handleAnullere(e);
        } else {
            holdtext.setPromptText("Navnet er allerede i brug");
            holdtext.clear();
        }
    }
}