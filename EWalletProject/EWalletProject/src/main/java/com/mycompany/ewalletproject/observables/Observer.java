package com.mycompany.ewalletproject.observables;

import com.mycompany.ewalletproject.walletitems.Cash;
import com.mycompany.ewalletproject.walletitems.CreditCard;


public class Observer implements IObserver{
    private ISubject obs;

    public Observer(ISubject obs){
       this.obs = obs;
       this.obs.attach(this);
    }

    public void update(IBalanceObservable bo){
        if(bo instanceof CreditCard){
            CreditCard cc = (CreditCard)bo;
            if(cc.getBalance() > (cc.getLimit()*0.5)){
                System.out.println("Balance is over half the limit");        
            }
        }
        else if(bo instanceof Cash){
            Cash c = (Cash)bo;
            if(c.getAmount()<30){
                System.out.println("Amount is less than $30"); 
            }
        }
    }
}
