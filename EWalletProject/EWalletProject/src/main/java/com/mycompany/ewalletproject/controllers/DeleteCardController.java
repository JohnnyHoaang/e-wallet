package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DeleteCardController {

    @FXML
    private ComboBox deleteCardBox;
    
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void deleteCard() throws IOException {
//        Wallet.get().deleteCard();
        App.setRoot("LandingPage");
        
    }
}
