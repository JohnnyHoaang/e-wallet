package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
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
        double cashAmount = Cash.get().getAmount();
        this.currentAmount.setText(this.currentAmount.getText() + "$" + cashAmount);
    }
    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }
    @FXML
    private void addCash() throws IOException{
        double cashAmount = Cash.get().getAmount();
        double addAmount = Double.parseDouble(this.amount.getText());
        Cash.get().setAmount(cashAmount + addAmount);
        cashAmount = Cash.get().getAmount();
        setCurrentAmounText(cashAmount);
    }
    private void setCurrentAmounText(double currentAmount){
        this.currentAmount.setText("Current Amount: $" + currentAmount);
    }
}
