package com.mycompany.ewalletproject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PaymentCardController {
    @FXML RadioButton creditButton;
    @FXML RadioButton debitButton;
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void switchToNextPage() throws IOException {
        
        if(creditButton.isSelected()){
            App.setRoot("CreditCard");
        }
        else if(debitButton.isSelected()){
            App.setRoot("DebitCard");
        }
    }
}
