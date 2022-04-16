package com.mycompany.ewalletproject.observables;

public interface ISubject {
    public void attach(IObserver b);
    public void detach(IObserver a);
    public void notifyObserver();
}
