package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.threads.RemindThread;
import com.mycompany.ewalletproject.walletitems.Date;
import com.mycompany.ewalletproject.walletitems.Note;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNoteController implements Initializable{


    @FXML
    private TextField creationDate;
    @FXML
    private TextArea noteText;
    @FXML
    private RadioButton yesReminder;
    @FXML
    private RadioButton noReminder;
    @FXML
    private TextField reminderFreq;   
    @FXML
    private ToggleGroup reminder;
    @FXML
    private RadioButton minReminder;
    @FXML
    private ToggleGroup reminderType;
    @FXML
    private RadioButton secReminder;
    @FXML
    private RadioButton daysReminder;
    
    @FXML ImageView eWalletImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
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
    private void addNote() throws IOException{
        Note note = new Note(new Date(creationDate.getText()), noteText.getText());
        Thread remindThread = new RemindThread(note);
        if (yesReminder.isSelected()){
           if(secReminder.isSelected()){
               note.setReminderFrequency(Long.parseLong(reminderFreq.getText())*1000);
               remindThread.start();
            }
           else if(minReminder.isSelected()){
               note.setReminderFrequency(Long.parseLong(reminderFreq.getText())*60000);
               remindThread.start();
         }
           else if(daysReminder.isSelected()){
               note.setReminderFrequency(Long.parseLong(reminderFreq.getText())*3600000);
               remindThread.start();
            }
       }
        Wallet.get().add(note);
        App.setRoot("LandingPage");
    }

    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }

}
