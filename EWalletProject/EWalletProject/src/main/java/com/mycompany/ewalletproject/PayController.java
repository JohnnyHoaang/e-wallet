package com.mycompany.ewalletproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import javafx.scene.control.*;

public class PayController {

    @FXML
    private TextField cardName;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField amount;
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void pay() throws IOException{
        App.setRoot("LandingPage");
    }
}
