package com.mycompany.ewalletproject.observables;

public class CashObserver implements IObserver{
    private ISubject obs;

    public CashObserver(ISubject obs){
       this.obs = obs;
       this.obs.attach(this);
    }

    public void update(){
        // this.balance = balance;
        // this.limit = limit;
    
        // if(balance > (limit*0.5)){
        //     System.out.println("Balance is over half the limit");        
        // }
    
    }

}
