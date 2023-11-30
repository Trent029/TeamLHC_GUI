package project.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void btnLoginClicked() throws IOException {
        //App.setRoot("home");
    }

    @FXML
    private void btnSignUpClicked() throws IOException{
        App.setRoot("signUp");
    }
}