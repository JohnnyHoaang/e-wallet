package com.mycompany.ewalletproject.threads;

import java.sql.SQLException;
import com.mycompany.ewalletproject.storage.Wallet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mycompany.ewalletproject.App;

import com.mycompany.ewalletproject.walletitems.Bank;
import com.mycompany.ewalletproject.walletitems.CreditCard;
import com.mycompany.ewalletproject.walletitems.Date;
import com.mycompany.ewalletproject.walletitems.DebitCard;

import com.mycompany.ewalletproject.walletitems.Note;
import com.mycompany.ewalletproject.walletitems.PersonalCard;

public class LoadWalletThread extends Thread{
    
    public void load() throws SQLException{
        //fetch data from database
        Wallet wallet = new Wallet();
        String cashSql = "SELECT * FROM CASH";
        PreparedStatement prepCash = App.getConnection().prepareStatement(cashSql);
        ResultSet rsCash = prepCash.executeQuery();

        while(rsCash.next()){
            wallet.setCash(rsCash.getDouble(1));
        }


        //Loading Note
        String noteSql = "SELECT * FROM NOTE";
        PreparedStatement prepNote = App.getConnection().prepareStatement(noteSql);
        ResultSet rsNote = prepNote.executeQuery();

        while(rsNote.next()){
            Note note = new Note(new Date(rsNote.getString(2)), rsNote.getString(3));
            note.setID(rsNote.getInt(1));
            wallet.add(note);
        }

        //Loading CreditCard
        String creditSql = "SELECT * FROM Credit_Card";
        PreparedStatement prepCredit = App.getConnection().prepareStatement(creditSql);
        ResultSet rsCredit = prepCredit.executeQuery();

        while(rsCredit.next()){
            CreditCard credit = new CreditCard(rsCredit.getString(1), rsCredit.getString(2), new Date(rsCredit.getString(3)),
                 rsCredit.getString(4), rsCredit.getDouble(5));

            wallet.add(credit);
        }

        //Loading DebitCard
        String debitSql = "SELECT * FROM Debit_Card JOIN Bank USING(bank_id)";
        PreparedStatement prepDebit = App.getConnection().prepareStatement(debitSql);
        ResultSet rsDebit = prepDebit.executeQuery();

        while(rsDebit.next()){
            Bank bank =  new Bank(rsDebit.getInt(4));
            bank.setID(Integer.parseInt(rsDebit.getString(1)));
            DebitCard debit = new DebitCard(rsDebit.getString(2),rsDebit.getString(3), bank);

            wallet.add(debit);
        }

        //Loading PersonalCard
        String personalSql = "SELECT * FROM Personal_Card";
        PreparedStatement prepPersonal = App.getConnection().prepareStatement(personalSql);
        ResultSet rsPersonal = prepPersonal.executeQuery();

        while(rsPersonal.next()){
            PersonalCard personal = new PersonalCard(rsPersonal.getString(1), rsPersonal.getString(2), new Date(rsPersonal.getString(3)));
            wallet.add(personal);
        }

        Wallet.set(new Wallet(wallet));
    }


    @Override
    public void run(){
        try {
            this.load();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
