package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.Date;
import com.mycompany.ewalletproject.walletitems.PersonalCard;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import javafx.scene.control.*;

public class PersonalCardController {

    @FXML
    private TextField cardName;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField expiryDate;
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void addPersonalCard() throws IOException {
        if (expiryDate.getText().equals("")){
            PersonalCard personal = new PersonalCard(cardName.getText(), cardNumber.getText());
            Wallet.get().add(personal);
        }
        else {
            PersonalCard personal = new PersonalCard(cardName.getText(), cardNumber.getText(), new Date(expiryDate.getText()));
            Wallet.get().add(personal);
        }
        App.setRoot("LandingPage");
        
    }
}
