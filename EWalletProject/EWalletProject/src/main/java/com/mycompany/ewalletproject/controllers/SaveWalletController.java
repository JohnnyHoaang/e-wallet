package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

public class SaveWalletController {
    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }

}