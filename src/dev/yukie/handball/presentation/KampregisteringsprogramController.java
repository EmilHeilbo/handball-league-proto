package dev.yukie.handball.presentation;

import javafx.fxml.FXML;
import dev.yukie.handball.logic.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class KampregisteringsprogramController{
    
    @FXML private Label hold;
    @FXML private Label kampe;
    @FXML private Label stilling;
    @FXML private ListView<String> holdList;
    @FXML private ListView<String> kampeList;
    @FXML private ListView<String> stillingList;
    @FXML private Button opretHold;
    @FXML private Button opretKamp;


    @FXML
    private void handleOpretHold(ActionEvent e){
        holdList.getItems().clear();
        holdList.getItems().addAll(Model.getHold());
        Model.addHold("Test");
        System.out.println("Trykkede paa opret Hold.");
        App.popupStage.setScene(App.sceneOpretHold);
        App.popupStage.show();
    }
    @FXML
    private void handleOpretKamp() {
        kampeList.getItems().clear();
        System.out.println("Trykkede paa opret Kamp.");
        App.popupStage.setScene(App.sceneOpretKamp);
        App.popupStage.show();
    }
    
    public void initialize() {
    	holdList.getItems().addAll(Model.getHold());
    }
}