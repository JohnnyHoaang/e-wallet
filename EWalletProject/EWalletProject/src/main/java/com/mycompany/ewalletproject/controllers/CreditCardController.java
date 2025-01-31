package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.threads.ImageFadeAnimationThread;
import com.mycompany.ewalletproject.walletitems.CreditCard;
import com.mycompany.ewalletproject.walletitems.CustomDate;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class CreditCardController implements Initializable{

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
    
    @FXML ImageView eWalletImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){ 
        Thread imageThread = new ImageFadeAnimationThread(eWalletImage);
        Platform.runLater(imageThread);
    }
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void addCreditCard() throws IOException {
        CreditCard credit = new CreditCard(cardName.getText(), cardNumber.getText(), 
                new CustomDate(expiryDate.getText()), securityCode.getText(), 
                Double.parseDouble(creditLimit.getText()));
        if(Wallet.get().countCards()==10){
            throw new UnsupportedOperationException("Limit of cards reached");
        }  
        Wallet.get().add(credit);
        App.setRoot("LandingPage");
    }
}
