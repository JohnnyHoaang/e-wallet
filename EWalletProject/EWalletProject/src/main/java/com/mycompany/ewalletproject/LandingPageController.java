/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ewalletproject;
import java.io.IOException;

import javafx.fxml.FXML;


/**
 *
 * @author josek
 */
public class LandingPageController {
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
        //testing
        for (Wallet w: Database.get().getDB()){
            w.printAll();
        }
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

