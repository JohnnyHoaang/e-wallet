package com.mycompany.ewalletproject.controllers;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.IWalletItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.*;

public class OpenWalletController implements Initializable{
    @FXML private GridPane walletPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        int count = 0;
        for (IWalletItem item : Wallet.get().getWallet()){
            StackPane stack = new StackPane();
            Text t = new Text(item.toString());
            t.setFill(Color.BLUE);
            Rectangle r = new Rectangle(t.getLayoutBounds().getWidth()+5,t.getLayoutBounds().getHeight()+5);
            r.setFill(Color.ORANGE);
            r.setStroke(Color.BLACK);
            stack.getChildren().addAll(r,t);
            walletPane.add(stack, 0, count);

            stack.setAlignment(Pos.TOP_LEFT);
            stack.setPadding(new Insets(10));
            count++;
        }
        
    }

    @FXML
    private void switchToLandingPage() throws IOException{
        App.setRoot("LandingPage");
    }

}