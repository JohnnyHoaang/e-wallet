package com.mycompany.ewalletproject.threads;

import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.IWalletItem;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class OpenWalletThread extends Thread{
    private Wallet wallet;
    private GridPane gridPane;

    public OpenWalletThread(Wallet wallet, GridPane gridPane){
        this.wallet = wallet;
        this.gridPane = gridPane;
    }
    @Override
    public void run(){
        int count = 0;
        for (IWalletItem item : this.wallet.getWallet()){
            StackPane stack = new StackPane();
            Text t = new Text(item.toString());
            t.setFill(Color.BLUE);
            Rectangle r = new Rectangle(t.getLayoutBounds().getWidth()+5,t.getLayoutBounds().getHeight()+5);
            r.setFill(Color.ORANGE);
            r.setStroke(Color.BLACK);
            stack.getChildren().addAll(r,t);
            gridPane.add(stack, 0, count);

            stack.setAlignment(Pos.TOP_LEFT);
            stack.setPadding(new Insets(10));
            count++;
        }
    }
}
