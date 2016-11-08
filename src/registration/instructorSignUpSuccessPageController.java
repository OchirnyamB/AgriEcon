package registration;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by bazarsad on 10/18/2016.
 */
public class instructorSignUpSuccessPageController {

    public void tryRegister(ActionEvent actionEvent) throws IOException {
        String message = "";
        System.out.println(message);
    }
    public void goBackToLoginPage(ActionEvent actionEvent) throws IOException {
        Parent signupPageParent = FXMLLoader.load(getClass().getResource("welcomePage.fxml"));
        Scene signupPageScene = new Scene(signupPageParent);
        Stage signupPageStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        signupPageStage.hide();
        signupPageStage.setScene(signupPageScene);
        signupPageStage.show();
    }
}
