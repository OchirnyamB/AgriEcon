package view;

import javafx.event.ActionEvent;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by bazarsad on 10/18/2016.
 */
public class signupPageController {
    @FXML
    private JFXRadioButton instructorRadioButton;
    @FXML
    private JFXRadioButton studentRadioButton;

    public void tryRegister(ActionEvent actionEvent) throws IOException {
        String message = "";
        System.out.println(message);
        if (instructorRadioButton.isSelected()){
            Parent signupPageParent = FXMLLoader.load(getClass().getResource("instructorSignUpPage.fxml"));
            Scene signupPageScene = new Scene(signupPageParent);
            Stage signupPageStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            signupPageStage.hide();
            signupPageStage.setScene(signupPageScene);
            signupPageStage.show();
        }
        if (studentRadioButton.isSelected()){
            Parent signupPageParent = FXMLLoader.load(getClass().getResource("studentSignUpPage.fxml"));
            Scene signupPageScene = new Scene(signupPageParent);
            Stage signupPageStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            signupPageStage.hide();
            signupPageStage.setScene(signupPageScene);
            signupPageStage.show();
        }

    }


}
