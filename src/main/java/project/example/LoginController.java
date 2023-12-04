package project.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ProjectFACADE;


public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink signUpButton;

    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtusername;

    @FXML
    private Label lbl_error;

    @FXML
    private void btnLoginClicked() throws IOException {
        
        String username=txtusername.getText();
        String password=txtpassword.getText();

        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        if(!projectFACADE.login(username, password))
        {
            lbl_error.setText("Invalid login credentials.");
            return;
        }
        else
        {
            lbl_error.setText("login successful");
        }

        //App.setRoot("home"); //go to project board of the user logged in
        
    }

    @FXML
    private void btnSignUpClicked() throws IOException{
        App.setRoot("signUp"); //go to signup page
    }
}