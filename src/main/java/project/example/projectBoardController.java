package project.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class projectBoardController {
    
    @FXML
    private Label lbl_title;

    @FXML
    private Button logoutButton;

    @FXML
    private Button settingsButton;

    @FXML
    private void btnLogoutClicked()throws IOException{
        //save info
        App.setRoot("login");
    }

    @FXML
    private void btnSettingsClicked()throws IOException{
        //App.setRoot("settings");
    }


    
}
