package com.mycompany.ewalletproject.observables;

import com.mycompany.ewalletproject.walletitems.CreditCard;

public class CreditObserver implements IObserver{
    private CreditCard obs;
    private double balance;
    private double limit;

    public CreditObserver(CreditCard obs){
       this.obs = obs;
       this.obs.attach(this);
    }

    public void update(){
        this.balance = this.obs.getBalance();
        this.limit = this.obs.getLimit();

        if(this.balance > (this.limit*0.5)){
            System.out.println("Balance is over half the limit");
        }
    
    }
}
