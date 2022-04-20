package com.mycompany.ewalletproject.controllers;

import java.io.IOException;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.threads.ImageFadeAnimationThread;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class PayController implements Initializable{
    @FXML RadioButton cash;
    @FXML RadioButton card;
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
    private void switchToNextPage() throws IOException {
        
        if(cash.isSelected()){
            App.setRoot("PayCash");
        }
        else if(card.isSelected()){
            App.setRoot("PayCard");
        }
    }
}
