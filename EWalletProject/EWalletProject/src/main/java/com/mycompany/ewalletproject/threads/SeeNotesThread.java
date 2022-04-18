package com.mycompany.ewalletproject.threads;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SeeNotesThread extends Thread{
    private GridPane gridPane;
    private ArrayList<String> notes;

    public SeeNotesThread(GridPane gridPane, ArrayList<String> notes){
        this.gridPane = gridPane;
        this.notes = notes;
    }
    // Creates rectangle for each note in wallet
    @Override
    public void run(){
        int count = 0;
        for (String note: this.notes){
            Text t = new Text(note);
            Rectangle r = new Rectangle(t.getLayoutBounds().getWidth()+5,t.getLayoutBounds().getHeight()+5);
            r.setFill(Color.ORANGE);
            r.setStroke(Color.BLACK);
            StackPane stack = new StackPane();
            stack.getChildren().addAll(r,t);
            stack.setAlignment(Pos.TOP_LEFT);
            stack.setPadding(new Insets(10)); 
            this.gridPane.add(stack, 0, count); //row column
            count++;
        }
    }
}
