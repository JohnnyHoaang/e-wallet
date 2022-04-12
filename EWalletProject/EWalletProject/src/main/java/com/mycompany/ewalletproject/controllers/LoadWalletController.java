package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.Database;
import com.mycompany.ewalletproject.Wallet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;

public class LoadWalletController implements Initializable {
    @FXML private GridPane walletPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        int count = 0;
        for (Wallet w: Database.get().getDB()){
            String walletStr = "Wallet " + w.getID();
            // could get amount too
            Button button = new Button("Wallet " + w.getID());
            String[] words = walletStr.split(" ");
            button.setOnAction(e-> setWallet(Integer.parseInt(words[1])));
            walletPane.add(button,0, count);
            count++;
        }
    }
    
    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }

    private void setWallet(int id){
        Wallet wallet = Database.get().load(id);
        Wallet.set(wallet);
        Wallet.get().printAll();
    }

}
