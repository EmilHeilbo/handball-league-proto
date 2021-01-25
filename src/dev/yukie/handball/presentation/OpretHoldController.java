package dev.yukie.handball.presentation;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
public class OpretHoldController {

    @FXML
    private void handleAnullere(ActionEvent e){
        App.popupStage.close();
    }

    /* TODO - Logik
    koer metoden addHold fra Model.java med String fra Lable,
    addHold, kalder createHold i JDBCHandler.java,
    createHold retunere True / False.
    Hvis True, tilfoejer den Stringen fra Lable til AppData.hold,
    og retunere true, og popup vinduet lukkes.
    Hvis False, retuneres False, og en fejlmeddelelse bliver vist, uden at vinduet lukkes.
    Fejlmeddelelsen fortaeller at navnet allerede er i databasen.
    OBS. Vi behoever ikke at kontrollere om den allerede er i databasen,
    eftersom databasen goer det for os. */
    @FXML
    private void opretHold(ActionEvent e){

    }
}