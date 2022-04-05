package com.mycompany.ewalletproject;

import java.util.ArrayList;

public class Wallet {
    private int id;
    private ArrayList<IWalletItem> wallet; 

    public Wallet(){
        this.wallet = new ArrayList<IWalletItem>();
    }
    public int getID(){
        return this.id;
    }
    public void add(IWalletItem wi){
        this.wallet.add(wi);
    }
    public void deleteCard(String cardNumber){
        for (IWalletItem w: wallet){
            if(w instanceof PaymentCard){
                if(((PaymentCard)w).getCardNumber().equals(cardNumber)){
                    this.wallet.remove(w);
                }
            }
        }
    }
    public void deleteNote(int id){
        for (IWalletItem w: wallet){
            if(w instanceof Note){
                if(((Note)w).getID()==id){
                    this.wallet.remove(w);
                }
            }
        }
    }
    public String browseNotes(){
        String result = "";
        for (IWalletItem w: wallet){
            if(w instanceof Note){
                result+= w.toString() + "\n";
            }
        }
        return result;
    }
}
