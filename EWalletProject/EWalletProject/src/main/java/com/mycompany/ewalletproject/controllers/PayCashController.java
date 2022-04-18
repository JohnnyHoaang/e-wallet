package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.observables.Observer;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.threads.ImageFadeAnimationThread;
import com.mycompany.ewalletproject.walletitems.Cash;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.application.Platform;


public class PayCashController implements Initializable {

    
    @FXML
    private TextField amount;
    @FXML
    private Text cashAmount;
    @FXML
    private Text firstText;
    @FXML ImageView eWalletImage;

    public void initialize(URL url, ResourceBundle resourceBundle){
        //double ca = Cash.get().getAmount();
        double ca = Wallet.get().getCash().getAmount();
        this.cashAmount.setText("Cash Amount: $" + ca);
        Thread imageThread = new ImageFadeAnimationThread(eWalletImage);
        Platform.runLater(imageThread);
    }
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void pay() throws IOException{
        Cash cash = Wallet.get().getCash();
        cash.deleteObservers();
        Observer cro = new Observer(cash);
        boolean payCheck = cash.pay(Double.parseDouble(this.amount.getText()));
        cashAmount.setText("Cash Amount: $" + cash.getAmount());
        if(payCheck){
            firstText.setText("Your payment was successful!");
        }
        else{
            firstText.setText("Your payment was not successful...");
        }
    }
}
