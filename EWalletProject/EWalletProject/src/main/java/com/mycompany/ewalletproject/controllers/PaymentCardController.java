package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentCardController implements Initializable{
    @FXML RadioButton creditButton;
    @FXML RadioButton debitButton;
    @FXML ImageView eWalletImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        FadeTransition fade = new FadeTransition();
        fade.setNode(eWalletImage);
        fade.setDuration(Duration.millis(1500));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setAutoReverse(true);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();  
    }
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void switchToNextPage() throws IOException {
        
        if(creditButton.isSelected()){
            App.setRoot("CreditCard");
        }
        else if(debitButton.isSelected()){
            App.setRoot("DebitCard");
        }
    }
}
