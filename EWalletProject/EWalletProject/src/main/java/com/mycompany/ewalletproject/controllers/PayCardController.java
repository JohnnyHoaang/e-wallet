package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.CreditCard;
import com.mycompany.ewalletproject.walletitems.DebitCard;
import com.mycompany.ewalletproject.walletitems.PaymentCard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;

public class PayCardController implements Initializable {

    @FXML
    private TextField amount;
    @FXML
    private ComboBox<String> payBox;
    @FXML
    private Text firstText;
    @FXML
    private Text secondText;
    @FXML 
    private Text paymentConfirmation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> options = FXCollections.observableArrayList(Wallet.get().getPaymentCardsList());
        payBox.setItems(options);
        payBox.setOnAction(e-> {
            try {
                show();
            } catch (IOException error) {
                error.printStackTrace();
            }
        });
    }

    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void pay() throws IOException{
        PaymentCard pc = Wallet.get().loadPaymentCard(payBox.getValue());
        boolean payConfirm = pc.withdraw(Integer.parseInt(amount.getText()));
        if(payConfirm){
            paymentConfirmation.setText("The payment was successful!");
        } else {
            paymentConfirmation.setText("The payment was not successful. Please try again.");
        }
        //App.setRoot("LandingPage");
    }
    private void show() throws IOException{
        PaymentCard pc = Wallet.get().loadPaymentCard(payBox.getValue());
        if (pc.getCardType().equals("debit")){
            setTextBlank();
            firstText.setText("The amount of the card is: $"+ ((DebitCard)pc).getBank().getAmount());
        }
        else if(pc.getCardType().equals("credit")) {
            setTextBlank();
            firstText.setText("The limit of the card is: $"+ ((CreditCard)pc).getLimit());
            secondText.setText("The balance of the card is: $"+ ((CreditCard)pc).getBalance());
        }
    }
    private void setTextBlank(){
        firstText.setText("");
        secondText.setText("");
        paymentConfirmation.setText("");
    }
}