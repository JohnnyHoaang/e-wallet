package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;

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
import javafx.util.Duration;

public class DeleteCardController implements Initializable {

    @FXML
    private ComboBox<String> deleteCardBox;
    @FXML ImageView eWalletImage;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> options = FXCollections.observableArrayList(Wallet.get().getAllCardsList());
        deleteCardBox.setItems(options);
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
    private void deleteCard() throws IOException {
        System.out.println(deleteCardBox.getValue());
        Wallet.get().deleteCard(deleteCardBox.getValue());
        App.setRoot("LandingPage");
        
    }
}
