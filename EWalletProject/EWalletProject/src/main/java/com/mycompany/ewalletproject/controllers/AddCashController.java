package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.Cash;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddCashController implements Initializable{

    @FXML private TextField amount;
    @FXML private Text currentAmount;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        double cashAmount = Wallet.get().getCash().getAmount();
        this.currentAmount.setText(this.currentAmount.getText() + "$" + cashAmount);
    }
    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }
    @FXML
    private void addCash() throws IOException{
        Cash cash = Wallet.get().getCash();
        double cashAmount = cash.getAmount();
        double addAmount = Double.parseDouble(this.amount.getText());
        cash.setAmount(cashAmount + addAmount);
        cashAmount = cash.getAmount();
        setCurrentAmounText(cashAmount);
    }
    private void setCurrentAmounText(double currentAmount){
        this.currentAmount.setText("Current Amount: $" + currentAmount);
    }
}
