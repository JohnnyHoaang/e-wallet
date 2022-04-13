package com.mycompany.ewalletproject.storage;

import java.util.ArrayList;

import com.mycompany.ewalletproject.walletitems.IWalletItem;
import com.mycompany.ewalletproject.walletitems.Note;
import com.mycompany.ewalletproject.walletitems.PaymentCard;

public class Wallet {
    private static int sequenceID = 0;
    private int id;
    private ArrayList<IWalletItem> wallet; 
    private static Wallet self = new Wallet();
    // get for static instance
    public static Wallet get(){ return self;}
    // set for loading wallet
    public static void set(Wallet wallet){ self = wallet;}

    public Wallet(){
        this.wallet = new ArrayList<IWalletItem>();
        this.id = Wallet.sequenceID++;
    }
    // copy constructor
    public Wallet(Wallet copyWallet){
        for (IWalletItem iw : copyWallet.getWallet()){
            this.wallet.add(iw);
        }
        this.id = Wallet.sequenceID++;
    }

    public ArrayList<IWalletItem> getWallet(){
        return this.wallet;
    }
    public IWalletItem getIWalletItem(int index){
        return this.wallet.get(index);
    }
    public int getID(){
        return this.id;
    }
    public void add(IWalletItem wi){
        this.wallet.add(wi);
    }
    public void deleteCard(String cardNumber){
        for (int i=0; i<wallet.size();i++){
            if(wallet.get(i) instanceof PaymentCard){
                if(((PaymentCard)wallet.get(i)).getCardNumber().equals(cardNumber)){
                    this.wallet.remove(i);
                }
            }
        }
    }
    public void deleteNote(int id){
        for (int i=0; i<wallet.size();i++){
            if(wallet.get(i) instanceof Note){
                if(((Note)wallet.get(i)).getID()==id){
                    this.wallet.remove(i);
                }
            }
        }
    }
    public void wipeAll(){
        for (IWalletItem iw: wallet){
            this.wallet.remove(iw);
        }
    }
    public ArrayList<String> browseNotes(){
        ArrayList<String> notes = new ArrayList<String>();
        for (IWalletItem w: wallet){
            if(w instanceof Note){
                notes.add(w.toString());
            }
        }
        return notes;
    }
    
    public void printAll(){
        for (IWalletItem i : wallet){
            System.out.println(i);
        }
    }

}
