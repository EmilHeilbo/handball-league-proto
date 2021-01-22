package dev.yukie.handball.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private FXMLLoader loader = new FXMLLoader();
    public static Stage stage = new Stage();
    public static Scene sceneKampregistreringsprogram;
    public static Scene sceneKamprapport;
    public static Scene sceneOpretHold;
    public static Scene sceneOpretKamp;
    public static Scene registrerKamp;
    private static Parent root;

    public static void main(String[] args) {
        System.out.println("start app :D");
        launch(args);
    }

    @Override
    public void start(Stage pStage) throws Exception {
        System.out.println("Inde i start().");
        loader.setLocation(getClass().getResource("Kampregistreringsprogram.fxml"));
        root = loader.load();
        sceneKampregistreringsprogram = new Scene(root);
        stage.setScene(sceneKampregistreringsprogram);
        stage.show();
        loader.
        loadAllFxml();
    }

    private void loadAllFxml() throws Exception{
        System.out.println("Inde i loadAllFxml().");
        loader.setLocation(getClass().getResource("Kamprapport.fxml"));
        System.out.println("Loadede resource.");
        root = loader.load();
        System.out.println("Loader.load uden fejl ?");
        sceneKamprapport = new Scene(root);
        System.out.println("Loadede kamprapport.");

        loader.setLocation(getClass().getResource("OpretHold.fxml"));
        root = loader.load();
        sceneOpretHold = new Scene(root);

        loader.setLocation(getClass().getResource("OpretKamp.fxml"));
        root = loader.load();
        sceneOpretKamp= new Scene(root);


    }
}
