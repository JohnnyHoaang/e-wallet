package com.mycompany.ewalletproject.storage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.walletitems.Cash;
import com.mycompany.ewalletproject.walletitems.CreditCard;
import com.mycompany.ewalletproject.walletitems.DebitCard;
import com.mycompany.ewalletproject.walletitems.IWalletItem;
import com.mycompany.ewalletproject.walletitems.Note;
import com.mycompany.ewalletproject.walletitems.PersonalCard;


public class Database{
    private Wallet db = new Wallet();
    private static Database self = new Database();
    public static Database get(){return self;}

    public Wallet getDB(){
        return this.db;
    }
    public void save(Wallet wallet) throws SQLException{
        // insert data to database
        
        for (IWalletItem item: wallet.getWallet()){
            if(item instanceof Cash){
                //insert cash
                String cashSql = "INSERT INTO CASH VALUES(?)";
                PreparedStatement prep = App.getConnection().prepareStatement(cashSql);
                prep.setDouble(1, ((Cash)item).getAmount());
                prep.execute();
            }
            else if(item instanceof Note){
                // insert note 
                String noteSql = "INSERT INTO NOTE VALUES(?,?,?,?)";
                PreparedStatement prep = App.getConnection().prepareStatement(noteSql);
                prep.setInt(1, ((Note)item).getID());
                prep.setString(2, ((Note)item).getCreationDate().toString());
                prep.setString(3, ((Note)item).getText());
                prep.setLong(4, ((Note)item).getReminderFrequency());
                prep.execute();
            }
            else if(item instanceof CreditCard){
                // insert credit card
                String creditCardSql = "INSERT INTO CREDIT_CARD VALUES(?,?,?,?,?,?)";
                PreparedStatement prep = App.getConnection().prepareStatement(creditCardSql);
                prep.setString(1, ((CreditCard)item).getCardName());
                prep.setString(2, ((CreditCard)item).getCardNumber());
                prep.setString(3, ((CreditCard)item).getExpiryDate().toString());
                prep.setString(4, ((CreditCard)item).getSecCode());
                prep.setDouble(5, ((CreditCard)item).getLimit());
                prep.setDouble(6, ((CreditCard)item).getBalance());
                prep.execute();
            }
            else if(item instanceof DebitCard){
                // insert debit card
                String bank = "INSERT INTO BANK VALUES (?,?)";
                String debitCardSql = "INSERT INTO DEBIT_CARD VALUES(?,?,?)";
                PreparedStatement prep = App.getConnection().prepareStatement(bank);
                prep.setInt(1, ((DebitCard)item).getBank().getID());
                prep.setDouble(2, ((DebitCard)item).getBank().getAmount());
                PreparedStatement secPrep = App.getConnection().prepareStatement(debitCardSql);
                secPrep.setString(1, ((DebitCard)item).getCardName());
                secPrep.setString(2, ((DebitCard)item).getCardNumber());
                secPrep.setInt(3, ((DebitCard)item).getBank().getID());
                prep.execute();
                secPrep.execute();
            }
            else if(item instanceof PersonalCard){
                String personalCardSql = "INSERT INTO PERSONAL_CARD VALUES(?,?,?)";
                PreparedStatement prep = App.getConnection().prepareStatement(personalCardSql);
                prep.setString(1,((PersonalCard)item).getName());
                prep.setString(2,((PersonalCard)item).getCardNumber());
                prep.setString(3,((PersonalCard)item).getExpiryDate().toString());
                prep.execute();
            }   
        }
    }
    public Wallet load(int id){
        // Fetch data from database

        
        Wallet wallet = null;
        return wallet;
    }
}