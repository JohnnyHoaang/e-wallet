package com.mycompany.ewalletproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

public class AddNoteController {


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
