package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.Wallet;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.*;

public class SeeNotesController implements Initializable {

    @FXML private GridPane notePane;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ArrayList<String> notes = Wallet.get().browseNotes();
        int count = 0;
        for (String note: notes){
            Text t = new Text(note);
            Rectangle r = new Rectangle(t.getLayoutBounds().getWidth(),100);
            r.setFill(Color.WHITE);
            StackPane stack = new StackPane();
            stack.getChildren().addAll(r,t);
            notePane.add(stack, 0, count); //row column
            count++;
        }
    }
    @FXML
    private void switchToLandingPage() throws IOException{
<<<<<<< HEAD
=======

>>>>>>> a257c47a31111cc56dbec8f89b3170ec1e5d09e7
        App.setRoot("LandingPage");
    }

}
