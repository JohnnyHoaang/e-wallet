package com.mycompany.ewalletproject.threads;

import com.mycompany.ewalletproject.storage.Database;
import com.mycompany.ewalletproject.storage.Wallet;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class LoadWalletThread extends Thread{
    private GridPane gridPane;
    private Database database;
    
    public LoadWalletThread(GridPane gridPane, Database database){
        this.gridPane = gridPane;
        this.database = database;
    }   
    @Override
    public void run(){
        int count = 0;
        for (Wallet w: this.database.getDB()){
            String walletStr = "Wallet " + w.getID();
            Button button = new Button("Wallet " + w.getID());
            String[] words = walletStr.split(" ");
            button.setOnAction(e-> setWallet(Integer.parseInt(words[1])));
            gridPane.add(button,0, count);
            count++;
        }
    }
    private void setWallet(int id){
        Wallet wallet = Database.get().load(id);
        Wallet.set(wallet);
    }
}
