package dev.yukie.handball.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private FXMLLoader loader = new FXMLLoader();
    private Stage stage = new Stage();
    private Scene scene;
    private Parent root;

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage pStage) throws Exception {
        loader.setLocation(getClass().getResource("Kampregistreringsprogram.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
