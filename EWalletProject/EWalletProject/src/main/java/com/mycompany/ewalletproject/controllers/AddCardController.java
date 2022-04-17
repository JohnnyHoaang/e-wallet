package com.mycompany.ewalletproject.controllers;

import java.io.IOException;

import com.mycompany.ewalletproject.App;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCardController implements Initializable{
    @FXML RadioButton paymentButton;
    @FXML RadioButton personalButton;
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
        
        if(paymentButton.isSelected()){
            App.setRoot("PaymentCard");
        }
        else if(personalButton.isSelected()){
            App.setRoot("PersonalCard");
        }
    }
}
