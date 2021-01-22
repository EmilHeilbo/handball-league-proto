package dev.yukie.handball.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private FXMLLoader loader = new FXMLLoader();
    public static Stage stage = new Stage();
    public static Scene scene;
    public static Parent root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) throws Exception {
        loader.setLocation(getClass().getResource("Kampregistreringsprogram.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private void loadAllFxml(Stage pStage) throws Exception{
        loader.setLocation(getClass().getResource("Kamprapport.fxml"));
        root = loader.load();
        Scene sceneKampRapport = new Scene(root);
        stage.setScene(scene);
        stage.show();

        loader.setLocation(getClass().getResource("OpretHold.fxml"));
        root = loader.load();
        Scene sceneOpretHold = new Scene(root);
        stage.setScene(scene);
        stage.show();

        loader.setLocation(getClass().getResource("OpretKamp.fxml"));
        root = loader.load();
        Scene sceneOpretKamp= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}
