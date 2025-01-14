package com.mycompany.ewalletproject.walletitems;

import java.util.ArrayList;

import com.mycompany.ewalletproject.observables.IObserver;
import com.mycompany.ewalletproject.observables.ISubject;
import com.mycompany.ewalletproject.strategy.IPay;

public class Cash implements IWalletItem, ISubject, IPay{
  private double amount;
  private ArrayList<IObserver> observers = new ArrayList<IObserver>();

  //Default Constructor
  public Cash(){
    this.amount = 0;
  }
  // Constructor with amount
  public Cash(double amount) {
    if(amount<0){
      throw new IllegalArgumentException("Amount cannot be negative");
    }
    this.amount = amount;
  }
  // Copy Constructor
  public Cash(Cash cash){
    if(cash.getAmount()<0){
      throw new IllegalArgumentException("Amount cannot be negative");
    }
    this.amount = cash.getAmount();
  }

  //Get Method
  public double getAmount() {
    return amount;
  }
  public void setAmount(double amount) {
    this.amount = amount;
  }
  // Checks if amount is valid and withdraws amount from total amount
  public boolean withdraw(int amount){
    if(amount<0){
      throw new IllegalArgumentException("Amount cannot be negative");
    }
    boolean check = false;
    if(this.amount-amount < 0) {
      check = false;
    }
    else {
      setAmount(this.getAmount()-amount);
      check = true;
    }
    notifyObserver();
    return check;
  }

  public String toString(){
    return "Cash: \n $" + this.amount;
  }
  // Deletes all Observers
  public void deleteObservers(){
    observers.clear();
  }
  // Adds observer to observer list 
  @Override
  public void attach(IObserver b) {
    observers.add(b);
    
  }
  // Deletes observer from observer list 
  @Override
  public void detach(IObserver a){
    int index = observers.indexOf(a);
    this.observers.remove(index);
  }
  // Calls update method from observer
  @Override
  public void notifyObserver(){
    for(IObserver ob : observers){
      ob.update(this);
    }
  }

  

}
