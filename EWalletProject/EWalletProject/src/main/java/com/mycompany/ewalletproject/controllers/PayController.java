package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PayController {

    @FXML
    private TextField amount;
    @FXML
    private ComboBox payBox;
    
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void pay() throws IOException{
        App.setRoot("LandingPage");
    }
}
