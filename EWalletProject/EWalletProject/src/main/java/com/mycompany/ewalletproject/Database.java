package com.mycompany.ewalletproject;

import java.util.ArrayList;

public class Database{
    ArrayList<Wallet> db = new ArrayList<Wallet>();

    public void save(Wallet wallet){
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