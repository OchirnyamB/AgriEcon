package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class welcomePageController {

    public void tryLogin(ActionEvent actionEvent) {
    }
    public void trySignup(ActionEvent actionEvent) throws IOException {
        Parent signupPageParent = FXMLLoader.load(getClass().getResource("signupPage.fxml"));
        Scene signupPageScene = new Scene(signupPageParent);
        Stage signupPageStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        signupPageStage.hide();
        signupPageStage.setScene(signupPageScene);
        signupPageStage.show();
    }
}
