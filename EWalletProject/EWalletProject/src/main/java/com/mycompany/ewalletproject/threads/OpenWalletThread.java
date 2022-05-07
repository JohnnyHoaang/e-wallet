package com.mycompany.ewalletproject.threads;

import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.IWalletItem;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;

public class OpenWalletThread extends Thread{
    private Wallet wallet;
    private GridPane gridPane;

    public OpenWalletThread(Wallet wallet, GridPane gridPane){
        this.wallet = wallet;
        this.gridPane = gridPane;
    }
    // makes a rectangle pane for every item of the wallet
    @Override
    public void run(){
       this.showWallet();
    }
    public void showWallet(){
        int count = 0;
        int countColumn = 0;
        int column = 0;
        for (IWalletItem item : this.wallet.getWallet()){
            StackPane stack = new StackPane();
            Text t = new Text(item.toString());
            t.setFont(Font.font("Elephant", 12));
            t.setFill(Color.BLACK);
            Rectangle r = new Rectangle(t.getLayoutBounds().getWidth()+10,t.getLayoutBounds().getHeight()+10);
            r.setFill(Color.ORANGE);
            r.setStroke(Color.BLACK);
            stack.getChildren().addAll(r,t);
            if (countColumn == 5){
                count = 0;
                countColumn = 0;
                column++;
            }
            //gridPane.add(stack, column, count);
            gridPane.add(stack, column, count);
            stack.setAlignment(Pos.TOP_LEFT);
            stack.setPadding(new Insets(10));
            gridPane.setAlignment(Pos.TOP_LEFT);
            count++;
            countColumn++;
        }
    }
}
