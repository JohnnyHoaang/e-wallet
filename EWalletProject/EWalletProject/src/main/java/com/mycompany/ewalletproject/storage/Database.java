package com.mycompany.ewalletproject.storage;

import java.sql.CallableStatement;
import java.sql.SQLException;

import com.mycompany.ewalletproject.threads.LoadWalletThread;
import com.mycompany.ewalletproject.threads.SavingWalletThread;
import com.mycompany.ewalletproject.threads.DeleteTablesThread;



import javafx.application.Platform;


public class Database{
    private Wallet db = new Wallet();
    private static Database self = new Database();
    public static Database get(){return self;}

    public Wallet getDB(){
        return this.db;
    }
    public void save(Wallet wallet) throws SQLException{
        Thread delTables = new DeleteTablesThread();
        Platform.runLater(delTables);
        Thread walSave = new SavingWalletThread(wallet);
        Platform.runLater(walSave);
    }
    public void load() throws SQLException{
        Thread loadWall = new LoadWalletThread();
        Platform.runLater(loadWall);
    }
}