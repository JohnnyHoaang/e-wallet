package com.mycompany.ewalletproject.walletitems;

public class Bank {
  private int amount;
  //Default Constructor
  public Bank(int amount) {
    this.amount = amount;
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

}
