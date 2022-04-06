package com.mycompany.ewalletproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import javafx.scene.control.*;

public class DeleteCardController {

    @FXML
    private TextField cardName;
    @FXML
    private TextField cardNumber;
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void deleteCard() throws IOException {
        Wallet.get().deleteCard(cardNumber.getText(), cardName.getText());
        App.setRoot("LandingPage");
        
    }
}
