package registration;

import authenticate.*;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import connection.mySQLconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by bazarsad on 10/18/2016.
 */
public class signupPageController2 {
    private boolean passwordValidatorFlag = false;
    private boolean repeatedPasswordValidatorFlag = false;
    private boolean emailValidatorFlag = false;
    @FXML
    private JFXRadioButton instructorRadioButton;
    @FXML
    private JFXRadioButton studentRadioButton;
    @FXML
    private JFXPasswordField password1;
    @FXML
    private JFXPasswordField password2;
    @FXML
    private JFXTextField studentEmail;

    public void validateEmail(KeyEvent touchEvent){
         String email = studentEmail.getText();
         EmailValidator validatedEmail = new EmailValidator(email);
         if(validatedEmail.validateEmail()){
             studentEmail.setFocusColor(Paint.valueOf("#66ff66"));
             emailValidatorFlag = true;
         }else{
             studentEmail.setFocusColor(Paint.valueOf("#ff4d4d"));
             emailValidatorFlag = false;
         }
    }
    public void validatePassword(KeyEvent touchEvent) {
        String password = password1.getText();
        PasswordValidator validatedPassword = new PasswordValidator(password);
        if(validatedPassword.validatePassword()) {
            password1.setFocusColor(Paint.valueOf("#66ff66"));
            passwordValidatorFlag = true;
            System.out.println("Password is valid!");
        }else{
            password1.setFocusColor(Paint.valueOf("#ff4d4d"));
            passwordValidatorFlag = false;
            System.out.println("Password is not valid!");
        }
    }
    public void validateRepeatedPassword(KeyEvent keyEvent) {
        String password = password1.getText();
        String repeatedPassword = password2.getText();
        PasswordValidator validatedPassword = new PasswordValidator(repeatedPassword);
        if(password.equals(repeatedPassword) && validatedPassword.validatePassword()){
            password2.setFocusColor(Paint.valueOf("#66ff66"));
            repeatedPasswordValidatorFlag = true;
        }else{
            password2.setFocusColor(Paint.valueOf("#ff4d4d"));
            repeatedPasswordValidatorFlag = false;
        }
    }
    public void tryRegister(ActionEvent actionEvent) throws IOException, SQLException, NoSuchAlgorithmException {
        String student_email = studentEmail.getText();
        String password = password1.getText();
        String repeatedPassword = password2.getText();

        if (instructorRadioButton.isSelected()) {
            // Instructor signup
            Parent signupPageParent = FXMLLoader.load(getClass().getResource("instructorSignUpPage.fxml"));
            Scene signupPageScene = new Scene(signupPageParent);
            Stage signupPageStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            signupPageStage.hide();
            signupPageStage.setScene(signupPageScene);
            signupPageStage.show();
        }
        if (studentRadioButton.isSelected()) {
            // Student signup
            Parent signupPageParent = FXMLLoader.load(getClass().getResource("studentSignUpPage.fxml"));
            if (passwordValidatorFlag == true && repeatedPasswordValidatorFlag == true && emailValidatorFlag == true) {
                // If passwords are all valid
                // Finally register
                Connection con = null;
                PreparedStatement ps = null;
                // Instance of hashing the registered password;
                EncryptPassword encryptedpassword = new EncryptPassword(password);
                encryptedpassword.generateStrongPasswordHash();
                String hashedpassword = encryptedpassword.getGeneratedHashKey();
                try {
                    // Finally inserting the student data
                    con = mySQLconnect.getConnection();
                    if (con != null) {
                        ps = con.prepareStatement("INSERT INTO students (studentEmail, studentPassword) VALUES(?, ?)");
                        ps.setString(1, student_email);
                        ps.setString(2, hashedpassword);
                        int rs = ps.executeUpdate();
                        if (rs == 0) {
                            System.out.println("Failed to register");
                        } else {
                            System.out.println("Successfully registered");
                            Scene signupPageScene = new Scene(signupPageParent);
                            Stage signupPageStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                            signupPageStage.hide();
                            signupPageStage.setScene(signupPageScene);
                            signupPageStage.show();
                        }
                    } else {
                        System.out.println("Failed to connect!");
                    }
                } catch (SQLException ex) {
                    System.out.println("Login error-->" + ex.getMessage());
                } finally {
                    mySQLconnect.close(con);
                }
            } else {

            }
        }
    }

}


