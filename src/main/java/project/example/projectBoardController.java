package project.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProjectBoardController {

    @FXML
    private Label lbl_title;

    @FXML
    private Button logoutButton;

    @FXML
    private Button settingsButton;

    @FXML
    private void btnLogoutClicked() throws IOException{
        //save users projects etc
        //basically facade logout
        App.setRoot("login");
    }
    
    @FXML
    private void btnSettingsClicked() throws IOException{
        App.setRoot("settings");
    }
    //need to have other projects that can be clicked on

}
