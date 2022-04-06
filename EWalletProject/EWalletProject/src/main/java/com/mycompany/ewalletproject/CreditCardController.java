package com.mycompany.ewalletproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import javafx.scene.control.*;

public class CreditCardController {

    @FXML
    private TextField cardName;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField expiryDate;
    @FXML
    private TextField securityCode;
    @FXML
    private TextField creditLimit;
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void addCreditCard() throws IOException {
        CreditCard credit = new CreditCard(cardName.getText(), cardNumber.getText(), 
                new Date(expiryDate.getText()), securityCode.getText(), 
                Double.parseDouble(creditLimit.getText()));
        //System.out.println(credit);
        Wallet.get().add(credit);
        App.setRoot("LandingPage");
    }
}
