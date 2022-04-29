package com.mycompany.ewalletproject.threads;

import java.sql.SQLException;

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
        try {
            Database.get().load();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
