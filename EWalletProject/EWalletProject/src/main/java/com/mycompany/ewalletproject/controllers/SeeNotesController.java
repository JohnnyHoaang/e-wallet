package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.threads.SeeNotesThread;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

public class SeeNotesController implements Initializable {

    @FXML private GridPane notePane;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        SeeNotesThread seeNotes = new SeeNotesThread(notePane, Wallet.get().browseNotes());
        Platform.runLater(seeNotes);
    }
    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }

}
