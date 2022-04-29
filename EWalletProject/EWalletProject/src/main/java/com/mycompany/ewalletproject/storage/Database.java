package com.mycompany.ewalletproject.storage;

import java.util.ArrayList;

public class Database{
    private Wallet db = new Wallet();
    private static Database self = new Database();
    public static Database get(){return self;}

    public Wallet getDB(){
        return this.db;
    }
    public void save(Wallet wallet){
        // insert data to database
    }
    public Wallet load(int id){
        //fetch data from database
        Wallet wallet = null;
        return wallet;
    }
}