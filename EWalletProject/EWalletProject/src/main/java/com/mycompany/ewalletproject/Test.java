package com.mycompany.ewalletproject;

public class Test {
  public static void main(String[] args){
    Database db = new Database();
    Note note = new Note(new Date("10/13"), "hi text 1");
    CreditCard cc = new CreditCard("Jo", "39210321", new Date("14/6"), "123", 60000);
    PersonalCard p = new PersonalCard("Dom", "4832390");
    Wallet.get().add(note);
    Wallet.get().add(cc);
    Wallet.get().add(p);
    // Wallet.get().printAll();
    db.get().save(Wallet.get());
    // Wallet.get().wipeAll();

    Wallet w2 = new Wallet();
    Wallet.set(w2);
    Note othernote = new Note(new Date("1/3"), "hi text 2");
    CreditCard othercc = new CreditCard("Hi", "1231421", new Date("4/6"), "123", 724000);
    PersonalCard otherp = new PersonalCard("Ye", "4243442");
    w2.add(othernote);
    w2.add(othercc);
    w2.add(otherp);
    //Wallet.get().printAll();
    db.get().save(Wallet.get());
    //give id
    db.get().load(1).printAll();;
  }
}
