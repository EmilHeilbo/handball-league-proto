package dev.yukie.handball.presentation;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class KampregisteringsprogramController {
    
    @FXML private Label hold;
    @FXML private ListView<String> holdList;

    @FXML
    private void handleOpretHold(ActionEvent e){
        System.out.println("Trykkede på Opret Hold knappen");
        hold.setText("Controller fungere!");
        
        holdList.getItems().add(holdList.getItems().size()+1+"");

        if(holdList.getItems().size()==4) {
            var list = holdList.getItems().listIterator();
            while(list.hasNext()){
                System.out.println(list.next());
            }
        }
    }

}