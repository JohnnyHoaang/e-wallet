package com.mycompany.ewalletproject.observables;

public class CreditObserver implements IObserver{
    private ISubject obs;
    private double balance;
    private double limit;

    public CreditObserver(ISubject obs){
       this.obs = obs;
       this.obs.attach(this);
    }

    public void update(double balance, double limit){
        // this.balance = balance;
        // this.limit = limit;
    
        if(balance > (limit*0.5)){
            System.out.println("Balance is over half the limit");        
        }
    
    }
}
