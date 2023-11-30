package project.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink signUpButton;

    @FXML
    private void btnLoginClicked() throws IOException {
        //App.setRoot("home"); //go to project board of the user logged in
    }

    @FXML
    private void btnSignUpClicked() throws IOException{
        App.setRoot("signUp"); //go to signup page
    }
}