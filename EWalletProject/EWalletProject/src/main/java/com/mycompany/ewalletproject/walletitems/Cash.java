package com.mycompany.ewalletproject.walletitems;

public class Cash {
  private double amount;

  public Cash(double amount) {
    this.amount = amount;
  }

  //Get Method
  public double getAmount() {
    return amount;
  }
  public void setAmount(double amount) {
    this.amount = amount;
  }

}
