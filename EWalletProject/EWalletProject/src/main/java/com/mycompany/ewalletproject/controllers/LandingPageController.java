/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ewalletproject.controllers;
import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Database;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.threads.ImageFadeAnimationThread;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.fxml.Initializable;


/**
 *
 * @author josek
 */
public class LandingPageController implements Initializable{
    @FXML
    private ImageView eWalletImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){ 
        Thread imageThread = new ImageFadeAnimationThread(eWalletImage);
        Platform.runLater(imageThread);
    }
    
    @FXML
    private void switchToAddCard() throws IOException {
        App.setRoot("AddCard");
    }
    @FXML
    private void switchToDeleteCard() throws IOException {
        App.setRoot("DeleteCard");
    }
    @FXML
    private void switchToPay() throws IOException {
        App.setRoot("Pay");
    }
    @FXML
    private void switchToSeeNotes() throws IOException {
        App.setRoot("SeeNotes");
    }
    @FXML
    private void switchToAddNote() throws IOException {
        App.setRoot("AddNote");
    }
    @FXML
    private void switchToSaveWallet() throws IOException {
        Database.get().save(Wallet.get());
        Wallet.set(new Wallet());
        App.setRoot("SaveWallet");
    }
    @FXML
    private void switchToLoadWallet() throws IOException {
        App.setRoot("LoadWallet");
    }
    @FXML
    private void switchToOpenWallet() throws IOException {
        App.setRoot("OpenWallet");
    }
    @FXML
    private void switchToAddCash() throws IOException {
        App.setRoot("AddCash");
    }
 
}

