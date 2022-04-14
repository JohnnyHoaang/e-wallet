package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.Cash;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class PayCashController implements Initializable {

    
    @FXML
    private TextField amount;
    @FXML
    private Text cashAmount;

    public void initialize(URL url, ResourceBundle resourceBundle){
        //double ca = Cash.get().getAmount();
        double ca = Wallet.get().getCash().getAmount();
        this.cashAmount.setText("Cash Amount: $" + ca);
    }
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void pay() throws IOException{
        Cash cash = Wallet.get().getCash();
        boolean payCheck = cash.pay(Double.parseDouble(this.amount.getText()));
        cashAmount.setText("Cash Amount: $" + cash.getAmount());
        if(payCheck){
            // your payment was successful
        }
        else{
            // you do not have enough cash...
        }
    }
}