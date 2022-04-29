package com.mycompany.ewalletproject.storage;

import java.util.ArrayList;

import com.mycompany.ewalletproject.walletitems.IWalletItem;

public class Database{
    private Wallet db = new Wallet();
    private static Database self = new Database();
    public static Database get(){return self;}

    public Wallet getDB(){
        return this.db;
    }
    public void save(Wallet wallet){
        // insert data to database
        for (IWalletItem item: wallet.getWallet()){
            if(item instanceof ){
                
            }
        }
    }
    public Wallet load(int id){
        //fetch data from database
        Wallet wallet = null;
        return wallet;
    }
}