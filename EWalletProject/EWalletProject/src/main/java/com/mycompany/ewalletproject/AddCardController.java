package com.mycompany.ewalletproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddCardController {
    @FXML RadioButton paymentButton;
    @FXML RadioButton personalButton;
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void switchToNextPage() throws IOException {
        
        if(paymentButton.isSelected()){
            App.setRoot("PaymentCard");
        }
        else if(personalButton.isSelected()){
            App.setRoot("PersonalCard");
        }
    }
}
