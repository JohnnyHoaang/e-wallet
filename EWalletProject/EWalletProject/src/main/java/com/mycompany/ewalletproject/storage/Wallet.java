package com.mycompany.ewalletproject.storage;

import java.util.ArrayList;

import com.mycompany.ewalletproject.walletitems.Cash;
import com.mycompany.ewalletproject.walletitems.IWalletItem;
import com.mycompany.ewalletproject.walletitems.Note;
import com.mycompany.ewalletproject.walletitems.PaymentCard;
import com.mycompany.ewalletproject.walletitems.PersonalCard;

public class Wallet {
    private static int sequenceID = 0;
    private int id;
    private ArrayList<IWalletItem> wallet; 
    private Cash cash = new Cash();
    private static Wallet self = new Wallet();
    // get for static instance
    public static Wallet get(){ return self;}
    // set for loading wallet
    public static void set(Wallet wallet){ self = wallet;}

    public Wallet(){
        this.wallet = new ArrayList<IWalletItem>();
        this.wallet.add(cash);
        this.id = Wallet.sequenceID++;
    }
    // copy constructor
    public Wallet(Wallet copyWallet){
        for (IWalletItem iw : copyWallet.getWallet()){
            this.wallet.add(iw);
        }
        this.id = Wallet.sequenceID++;
    }

    public Cash getCash(){
        return (Cash)wallet.get(0);
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
                    this.wallet.remove(wallet.get(i));
                }
            }
            else if(wallet.get(i) instanceof PersonalCard){
                if(((PersonalCard)wallet.get(i)).getCardNumber().equals(cardNumber)){
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

    public ArrayList<String> browseNotes(){
        ArrayList<String> notes = new ArrayList<String>();
        for (IWalletItem w: wallet){
            if(w instanceof Note){
                notes.add(w.toString());
            }
        }
        return notes;
    }
    public ArrayList<String> getPaymentCardsList(){
        ArrayList<String> pc = new ArrayList<String>();
        for (IWalletItem w: wallet){
            if(w instanceof PaymentCard){
                pc.add(((PaymentCard)w).getCardNumber());
            }
        }
        return pc;
    }
    public ArrayList<String> getAllCardsList(){
        ArrayList<String> cards = new ArrayList<String>();
        for (IWalletItem w: wallet){
            if(w instanceof PaymentCard){
                cards.add(((PaymentCard)w).getCardNumber());
            }
            else if(w instanceof PersonalCard){
                cards.add(((PersonalCard)w).getCardNumber());
            }
        }
        return cards;
    }
    
    public PaymentCard loadPaymentCard(String cardNumber){
        for(IWalletItem item: this.wallet){
            if(item instanceof PaymentCard){
                if(((PaymentCard)item).getCardNumber().equals(cardNumber)){
                    return (PaymentCard)item;
                }
            }
        }
        return null;
    }
    public void printAll(){
        for (IWalletItem i : wallet){
            System.out.println(i);
        }
    }

}
