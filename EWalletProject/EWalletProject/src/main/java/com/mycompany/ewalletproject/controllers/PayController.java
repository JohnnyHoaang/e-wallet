package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.PaymentCard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;

public class PayController implements Initializable {

    @FXML
    private TextField amount;
    @FXML
    private ComboBox<String> payBox;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> options = FXCollections.observableArrayList(Wallet.get().getPaymentCardsList());
        payBox.setItems(options);
    }

    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void pay() throws IOException{
        PaymentCard pc = Wallet.get().loadPaymentCard(payBox.getValue());
        pc.withdraw(Integer.parseInt(amount.getText()));
        App.setRoot("LandingPage");
    }
}
