package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Database;
import com.mycompany.ewalletproject.threads.LoadWalletThread;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.util.Duration;


public class LoadWalletController implements Initializable {
    @FXML private GridPane walletPane;
    @FXML private Pane ewalletPane;
    @FXML ImageView eWalletImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        LoadWalletThread loadWallet = new LoadWalletThread(walletPane, Database.get());
        Platform.runLater(loadWallet);
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
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }
}
