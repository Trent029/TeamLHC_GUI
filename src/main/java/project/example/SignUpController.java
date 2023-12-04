package project.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ProjectFACADE;

public class SignUpController {

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField txt_Email;

    @FXML
    private TextField txt_firstName;

    @FXML
    private TextField txt_lastName;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_passwordConfirm;

    @FXML
    private Label lbl_error;

    @FXML
    private void btnSignUpClicked() throws IOException {
        //App.setRoot("home"); //go to empty project board for user to create a project
        String firstName = txt_firstName.getText();
        String lastName = txt_lastName.getText();
        String email = txt_Email.getText();
        
        String password= txt_password.getText();
        String passwordConfirm = txt_passwordConfirm.getText();

        //check for empty fields
        if((firstName.equals("") || lastName.equals("")) || email.equals("") || password.equals("") || passwordConfirm.equals("") )
        {
            lbl_error.setText("You cannot leave any blank fields");
            return;
        }

        //check if confirm password==passwword
        if(!(password.equals(passwordConfirm)))
        {
            lbl_error.setText("password must match");
            return;
        }

        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();

        //create account
        if(!projectFACADE.signUp(firstName, lastName, email, password))
        {
            lbl_error.setText("User could not be created:(");
        }
        
        boolean login = projectFACADE.login(email,password);
        if(login)
        {
            lbl_error.setText("Login Successful");
        }

        //User user = projectFACADE.getUser();
        App.setRoot("projectBoard");
        


    }
}