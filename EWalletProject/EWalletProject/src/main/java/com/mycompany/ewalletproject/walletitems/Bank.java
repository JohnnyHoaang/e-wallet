package com.mycompany.ewalletproject.walletitems;

public class Bank {
  private int amount;
  private static int sequenceNum = 0;
  private int id;
  
  //Default Constructor
  public Bank(int amount) {
    this.amount = amount;
    this.id = sequenceNum++;
  }
  //Copy Constructor
  public Bank(Bank b) {
    this.amount = b.getAmount();
  }
  public int getAmount() {
    return amount;
  }
  public void setAmount(int amount) {
    this.amount = amount;
  }
  
  public int getID() {
    return this.id;
  }
  public void setID(int id) {
    this.id = id;
  }
}
