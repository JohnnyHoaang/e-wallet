package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;

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
import javafx.geometry.*;

public class SeeNotesController implements Initializable {

    @FXML private GridPane notePane;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ArrayList<String> notes = Wallet.get().browseNotes();
        int count = 0;
        for (String note: notes){
            Text t = new Text(note);
            Rectangle r = new Rectangle(t.getLayoutBounds().getWidth()+5,t.getLayoutBounds().getHeight()+5);
            r.setFill(Color.ORANGE);
            r.setStroke(Color.BLACK);
            StackPane stack = new StackPane();
            stack.getChildren().addAll(r,t);
            stack.setAlignment(Pos.TOP_LEFT);
            stack.setPadding(new Insets(10)); 
            notePane.add(stack, 0, count); //row column
            count++;
        }
    }
    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }

}
