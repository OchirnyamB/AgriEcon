package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class welcomePage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("welcomePage.fxml"));
        primaryStage.setTitle("Agricultural Economics Game");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.hide();
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
