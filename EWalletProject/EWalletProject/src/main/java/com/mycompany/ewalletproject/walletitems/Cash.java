package com.mycompany.ewalletproject.walletitems;

public class Cash implements IWalletItem{
  private double amount;

  public Cash(){
    this.amount = 0;
  }
  public Cash(double amount) {
    this.amount = amount;
  }
  public Cash(Cash cash){
    this.amount = cash.getAmount();
  }

  //Get Method
  public double getAmount() {
    return amount;
  }
  public void setAmount(double amount) {
    this.amount = amount;
  }
  public boolean pay(double amount){
    boolean check = false;
    if(this.amount-amount < 0) {
      check = false;
    }
    else {
      setAmount(this.getAmount()-amount);
      check = true;
    }
    return check;
  }
  public String toString(){
    return "$" + this.amount;
  }

}
