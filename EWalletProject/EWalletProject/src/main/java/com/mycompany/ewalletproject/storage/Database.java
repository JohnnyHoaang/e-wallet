package com.mycompany.ewalletproject.storage;

import java.util.ArrayList;

public class Database{
    ArrayList<Wallet> db = new ArrayList<Wallet>();
    private static Database self = new Database();
    public static Database get(){return self;}

    public ArrayList<Wallet> getDB(){
        return this.db;
    }
    public void save(Wallet wallet){
        
        for (Wallet w: db){
            if (w.getID() == wallet.getID()){
                w = wallet;
                return;
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