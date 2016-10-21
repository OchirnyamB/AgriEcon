package view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bazarsad on 10/18/2016.
 */
public class instructorSignUpPageController{
    public void finishRegister(ActionEvent actionEvent) throws IOException {
        Parent signupPageParent = FXMLLoader.load(getClass().getResource("instructorSignUpSuccessPage.fxml"));
        Scene signupPageScene = new Scene(signupPageParent);
        Stage signupPageStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        signupPageStage.hide();
        signupPageStage.setScene(signupPageScene);
        signupPageStage.show();
    }
}
