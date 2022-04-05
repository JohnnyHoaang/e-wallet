package com.mycompany.ewalletproject;

public class PersonalCard implements IWalletItem{
    private String name;
    private String number;
    private Date expiryDate = null;


    public PersonalCard(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public PersonalCard(String name, String number, Date expiryDate) {
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

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
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
        return result;
    }

    
}
