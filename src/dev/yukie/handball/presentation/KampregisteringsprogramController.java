package dev.yukie.handball.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class KampregisteringsprogramController {
    
    @FXML
    private Label hold;

    @FXML
    private void handleOpretHold(ActionEvent e){
        System.out.println("Trykkede på Opret Hold knappen");
        hold.setText("Controller fungere!");
    }

}