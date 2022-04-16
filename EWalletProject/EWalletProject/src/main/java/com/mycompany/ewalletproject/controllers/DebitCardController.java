package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.Bank;
import com.mycompany.ewalletproject.walletitems.DebitCard;

import java.io.IOException;

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
        Wallet.get().add(debit);
        App.setRoot("LandingPage");
        
    }
}

