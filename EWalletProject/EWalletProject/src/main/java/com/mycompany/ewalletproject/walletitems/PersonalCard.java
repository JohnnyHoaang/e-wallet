package com.mycompany.ewalletproject.walletitems;

public class PersonalCard implements IWalletItem{
    private String name;
    private String number;
    private CustomDate expiryDate = null;

    // Default constructor
    public PersonalCard(String name, String number) {
        this.name = name;
        this.number = number;
    }
    // Constructor with expiry date
    public PersonalCard(String name, String number, CustomDate expiryDate) {
        this.name = name;
        this.number = number;
        this.expiryDate = expiryDate;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public CustomDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(CustomDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public String toString(){
        String result;
        if(this.expiryDate == null){
            result = "Name: "+this.name+
                "\nNumber: "+this.number;
        }
        else{
            result = "Name: "+this.name+
                "\nNumber: "+this.number+
                "\nDate: "+this.expiryDate;
        }
        return "Personal Card: \n" + result;
    }
    

    
}
