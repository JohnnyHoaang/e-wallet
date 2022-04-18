package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.threads.ImageFadeAnimationThread;
import com.mycompany.ewalletproject.threads.OpenWalletThread;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.util.Duration;


public class OpenWalletController implements Initializable{
    @FXML private GridPane walletPane;
    @FXML ImageView eWalletImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        OpenWalletThread openWallet = new OpenWalletThread(Wallet.get(), walletPane);
        Platform.runLater(openWallet);
        Thread imageThread = new ImageFadeAnimationThread(eWalletImage);
        Platform.runLater(imageThread);
    }

    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }

}