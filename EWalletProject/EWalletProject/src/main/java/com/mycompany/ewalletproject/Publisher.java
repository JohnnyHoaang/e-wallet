package com.mycompany.ewalletproject;
public class Publisher {
    private int pubid;
    private String name;
    private String contact;
    private String phone;

    public Publisher(int pubid, String name, String contact, String phone){
        this.pubid = pubid;
        this.name = name;
        this.contact = contact;
        this.phone = phone;
    }

    public int getPubid(){
        return this.pubid;
    }
    public String getName(){
        return this.name;
    }
    public String getContact(){
        return this.contact;
    }
    public String getPhone(){
        return this.phone;
    }
    //to string method
    public String toString(){
        return "Pubid: "+ this.pubid + ", Publisher Name: " + this.name + ", Publisher Contact: " + this.contact + ", Publisher Phone: " + this.phone;
    }
}
