package com.mycompany.ewalletproject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import javafx.scene.control.*;

public class PersonalCardController {

    @FXML
    private TextField cardName;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField expiryDate;
    @FXML
    private void switchToLandingPage() throws IOException {
        App.setRoot("LandingPage");
    }
    @FXML
    private void addPersonalCard() throws IOException {
        if (expiryDate.equals("")){
            PersonalCard personal = new PersonalCard(cardName.getText(), cardNumber.getText());
            System.out.println(personal);
        }
        else {
            PersonalCard personal = new PersonalCard(cardName.getText(), cardNumber.getText(), new Date(expiryDate.getText()));
            System.out.println(personal);
        }
        App.setRoot("LandingPage");
        
    }
}
