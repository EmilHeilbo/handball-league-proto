package dev.yukie.handball.presentation;

import dev.yukie.handball.logic.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {
    private FXMLLoader loader = new FXMLLoader();
    private Parent root;
    public static final Model model = new Model();
    public static Stage stage = new Stage();
    public static Stage popupStage = new Stage();
    public static Scene sceneKampregistreringsprogram;
    public static Scene sceneKamprapport;
    public static Scene sceneOpretHold;
    public static Scene sceneOpretKamp;
    public static Scene registrerKamp;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) throws Exception {
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(stage);
        loader.setLocation(getClass().getResource("Kampregistreringsprogram.fxml"));
        root = loader.load();
        sceneKampregistreringsprogram = new Scene(root);
        stage.setScene(sceneKampregistreringsprogram);
        stage.setTitle("Kampregistreringsprogram");
        loadAllFxml();
        stage.show();
    }

    private void loadAllFxml() throws Exception {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Kamprapport.fxml"));
        root = loader.load();
        sceneKamprapport = new Scene(root);

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("OpretHold.fxml"));
        root = loader.load();
        sceneOpretHold = new Scene(root);

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("OpretKamp.fxml"));
        root = loader.load();
        sceneOpretKamp = new Scene(root);

    }
}
