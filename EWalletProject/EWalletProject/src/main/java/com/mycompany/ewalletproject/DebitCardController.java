package com.mycompany.ewalletproject;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import javafx.scene.control.*;

public class DebitCardController {

    @FXML
    private TextField cardName;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField cardAmount;
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void addDebitCard() throws IOException {
        DebitCard debit = new DebitCard(cardName.getText(), cardNumber.getText(), new Bank(Integer.parseInt(cardAmount.getText())));
        //System.out.println(debit);
        Wallet.get().add(debit);
        App.setRoot("LandingPage");
        
    }
}

