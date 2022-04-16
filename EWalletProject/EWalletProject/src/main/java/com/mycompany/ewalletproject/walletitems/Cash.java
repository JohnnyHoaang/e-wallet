package com.mycompany.ewalletproject.walletitems;

import java.util.ArrayList;

import com.mycompany.ewalletproject.observables.IBalanceObservable;
import com.mycompany.ewalletproject.observables.IObserver;
import com.mycompany.ewalletproject.observables.ISubject;

public class Cash implements IWalletItem, ISubject, IBalanceObservable{
  private double amount;
  private ArrayList<IObserver> observers = new ArrayList<IObserver>();

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
    notifyObserver();
    return check;
  }
  public String toString(){
    return "$" + this.amount;
  }
  public void deleteObservers(){
    observers.clear();
  }

  @Override
  public void attach(IObserver b) {
    observers.add(b);
    
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

  

}
