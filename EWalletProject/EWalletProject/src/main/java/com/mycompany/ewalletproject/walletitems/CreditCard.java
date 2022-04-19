package com.mycompany.ewalletproject.walletitems;

import java.util.ArrayList;

import com.mycompany.ewalletproject.observables.IObserver;
import com.mycompany.ewalletproject.observables.ISubject;

public class CreditCard extends PaymentCard  implements ISubject{
  private ArrayList<IObserver> observers = new ArrayList<IObserver>();

  private Date expiryDate;
  private String secCode;
  private double limit;
  private double balance = 0;

  public CreditCard(String cardName, String cardNumber, Date expiryDate, String secCode, double limit){
    super(cardName, cardNumber);
    if (limit<100 || limit>5000){
      throw new IllegalArgumentException("Limit is too high or too low.");
    }
    this.expiryDate = expiryDate;
    this.secCode = secCode;
    this.limit = limit;
  }

  //Get Methods
  public Date getExpiryDate() {
    return expiryDate;
  }
  public String getSecCode() {
    return secCode;
  }
  public double getLimit(){
    return this.limit;
  }
  public double getBalance(){
    return this.balance;
  }

  //Subject methods
  @Override
  public void attach(IObserver a){
    this.observers.add(a);
  }

  @Override
  public void detach(IObserver a){
    int index = observers.indexOf(a);
    this.observers.remove(index);
  }

  @Override
  public void notifyObserver(){
    for(IObserver ob : observers){
      ob.update(this);
    }
  }
  public void deleteObservers(){
    observers.clear();
  }
  // Checks if amount is valid and withdraws amount from total amount
  @Override
  public boolean withdraw(int amount){
    if (amount<0){
      throw new IllegalArgumentException("Amount cannot be negative");
    }
    if((this.balance+amount) > limit){
      return false;
    }
    else {
      this.balance+= amount;
    }
    this.notifyObserver();
    return true;
  }

  @Override
  public String getCardType(){
    return "credit";
  }
  public String toString(){
      String repr = "\nDate: " + this.expiryDate + 
              " \nSecurity code: " + this.secCode + 
              " \nLimit: $" + this.limit+
              "\nBalance: $" + this.balance;
        return "Credit Card: \n" + super.toString() + repr;
  }



}
