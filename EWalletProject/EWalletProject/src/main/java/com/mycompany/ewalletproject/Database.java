package com.mycompany.ewalletproject;

import java.util.ArrayList;

public class Database{
    ArrayList<Wallet> db = new ArrayList<Wallet>();
    private static Database self = new Database();
    public Database get(){return self;}

    public void save(Wallet wallet){
        for (Wallet w: db){
            if (w.getID() == wallet.getID()){
                throw new UnsupportedOperationException("Cannot add same wallet to the database");
            }
        }
        db.add(wallet);
    }
    public Wallet load(int id){
        Wallet wallet = null;
        for (Wallet w: db){
            if (w.getID() == id){
                wallet = w;
            }
        }
        return wallet;
    }
}