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


public class LoadWalletController implements Initializable {
    @FXML private GridPane walletPane;
    @FXML private Pane ewalletPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        LoadWalletThread loadWallet = new LoadWalletThread(walletPane, Database.get());
        Platform.runLater(loadWallet);
    }
    
    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }
}
