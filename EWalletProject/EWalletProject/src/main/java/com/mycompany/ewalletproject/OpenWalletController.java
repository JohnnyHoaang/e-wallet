package com.mycompany.ewalletproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

public class OpenWalletController {


    
    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }

}