package com.mycompany.ewalletproject.walletitems;

/**
 *
 * @author 2038364
 */
public class PaymentCard implements IWalletItem{
    private String cardName;
    private String cardNumber;
    
    // Default Constructor
    public PaymentCard(String cardName, String cardNumber){
        this.cardName = cardName;
        this.cardNumber = cardNumber;
    }
    
    public String toString(){
        return "Card Name "+this.cardName+
                "\nCard Number: "+this.cardNumber;
    }
    //Get Method
    public String getCardName(){
        return this.cardName;
    }
    public String getCardNumber(){
        return this.cardNumber;
    }
    // Override methods
    public boolean withdraw(int amount){
        return false;
    }
    public String getCardType(){
        return "";
    }
}
