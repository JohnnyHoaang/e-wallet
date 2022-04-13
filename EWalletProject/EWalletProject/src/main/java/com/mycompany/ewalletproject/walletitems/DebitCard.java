package com.mycompany.ewalletproject.walletitems;

public class DebitCard extends PaymentCard{
  private Bank bank;  

  public DebitCard(String cardName, String cardNumber, Bank bank){
    super(cardName, cardNumber);
    this.setBank(bank);
  }

  public boolean checkFundsAvailability(int amount){
    boolean check = false;
    if(this.bank.getAmount() >= amount){
      check = true;
    }
    return check;
  }
  @Override
  public boolean withdraw(int amount){
    boolean checkFunds = this.checkFundsAvailability(amount);
    int bankAmount = this.bank.getAmount();

    if(checkFunds){
      this.bank.setAmount(bankAmount - amount);
    }
    return checkFunds;
  }
  @Override
  public String getCardType(){
    return "debit";
  }
  //Get Method
  public Bank getBank() {
    return bank;
  }
  public void setBank(Bank bank) {
    this.bank = bank;
  }
  public String toString(){
      String repr = "";
      repr = "\nAmount: "+this.bank.getAmount();
      return super.toString() + repr;
  }
}
