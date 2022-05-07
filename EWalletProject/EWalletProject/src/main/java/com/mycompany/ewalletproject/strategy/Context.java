package com.mycompany.ewalletproject.strategy;

public class Context {
    private static Context self = new Context();
    public static Context get(){ return self;}

    private IPay pay;

    public Context() {
    }
    
    public void setPayment(IPay pay){
        this.pay = pay;
    }  

    public boolean showPayment(int amount){
        return this.pay.withdraw(amount);
    }

}
