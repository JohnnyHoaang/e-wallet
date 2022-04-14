package com.mycompany.ewalletproject.controllers;

import java.io.IOException;

import com.mycompany.ewalletproject.App;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PayController {
    @FXML RadioButton cash;
    @FXML RadioButton card;
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void switchToNextPage() throws IOException {
        
        if(cash.isSelected()){
            App.setRoot("PayCash");
        }
        else if(card.isSelected()){
            App.setRoot("PayCard");
        }
    }
}
