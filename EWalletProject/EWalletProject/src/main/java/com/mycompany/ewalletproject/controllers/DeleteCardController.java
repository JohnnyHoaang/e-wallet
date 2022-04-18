package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.threads.ImageFadeAnimationThread;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.util.Duration;

public class DeleteCardController implements Initializable {

    @FXML
    private ComboBox<String> deleteCardBox;
    @FXML ImageView eWalletImage;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> options = FXCollections.observableArrayList(Wallet.get().getAllCardsList());
        deleteCardBox.setItems(options);
        Thread imageThread = new ImageFadeAnimationThread(eWalletImage);
        Platform.runLater(imageThread);
    }

    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void deleteCard() throws IOException {
        System.out.println(deleteCardBox.getValue());
        Wallet.get().deleteCard(deleteCardBox.getValue());
        App.setRoot("LandingPage");
        
    }
}
