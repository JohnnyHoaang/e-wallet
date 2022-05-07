package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.threads.ImageFadeAnimationThread;
import com.mycompany.ewalletproject.walletitems.CustomDate;
import com.mycompany.ewalletproject.walletitems.PersonalCard;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonalCardController implements Initializable{

    @FXML
    private TextField cardName;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField expiryDate;
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
    private void addPersonalCard() throws IOException {
        PersonalCard personal = null;
        if (expiryDate.getText().equals("")){
            personal = new PersonalCard(cardName.getText(), cardNumber.getText());   
        }
        else {
            personal = new PersonalCard(cardName.getText(), cardNumber.getText(), new CustomDate(expiryDate.getText()));
        }
        if(Wallet.get().countCards()==10){
            throw new IllegalArgumentException("Limit of cards reached");
        }
        Wallet.get().add(personal);
        App.setRoot("LandingPage");
        
    }
}
