package com.mycompany.ewalletproject.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.Bank;
import com.mycompany.ewalletproject.walletitems.CreditCard;
import com.mycompany.ewalletproject.walletitems.Date;
import com.mycompany.ewalletproject.walletitems.DebitCard;
import com.mycompany.ewalletproject.walletitems.Note;
import com.mycompany.ewalletproject.walletitems.PaymentCard;
import com.mycompany.ewalletproject.walletitems.PersonalCard;

public class WalletTests {
    @Test
    public void deleteCreditCardTest(){
        Wallet w = new Wallet();
        CreditCard cc = new CreditCard("", "10032", new Date("12/11"), "123", 700);
        w.add(cc);
        assertEquals(2, w.getWallet().size());
        w.deleteCard(cc.getCardNumber());
        assertEquals(1, w.getWallet().size());
    }
    @Test
    public void deleteDebitCardTest(){
        Wallet w = new Wallet();
        DebitCard dc = new DebitCard("Joe", "238132", new Bank(60));
        w.add(dc);
        assertEquals(2, w.getWallet().size());
        w.deleteCard(dc.getCardNumber());
        assertEquals(1, w.getWallet().size());
    }
    @Test
    public void deleteNoteTest(){
        Wallet w = new Wallet();
        Note n = new Note(new Date("10/21"), "Hello");
        w.add(n);
        assertEquals(2, w.getWallet().size());
        w.deleteNote(n.getID());
        assertEquals(1, w.getWallet().size());
    }

    @Test
    public void browseNotesTest(){
        Note n = new Note(new Date("10/21"), "Hello 1");
        Note n2 = new Note(new Date("11/22"), "Hello 2");
        Note n3 = new Note(new Date("12/23"), "Hello 3");
        Wallet w = new Wallet();
        w.add(n);
        w.add(n2);
        w.add(n3);
        ArrayList<String> notesContent = w.browseNotes();
        assertEquals(3, notesContent.size());
    }
    @Test
    public void getPaymentCardsTest(){
        Wallet w = new Wallet();
        w.add(new CreditCard("", "3212321", new Date("23/11"), "321", 549));
        w.add(new DebitCard("", "321545", new Bank(7000)));
        w.add(new CreditCard("", "32655", new Date("23/12"), "657", 503));
        ArrayList<String> allCards = w.getPaymentCardsList();
        assertEquals(3, allCards.size());
        assertEquals("3212321", allCards.get(0));
        assertEquals("321545", allCards.get(1));
        assertEquals("32655", allCards.get(2));
    }
    @Test
    public void getAllCardsTest(){
        Wallet w = new Wallet();
        w.add(new CreditCard("", "3212321", new Date("23/11"), "321", 549));
        w.add(new DebitCard("", "321545", new Bank(7000)));
        w.add(new CreditCard("", "32655", new Date("23/12"), "657", 503));
        w.add(new PersonalCard("", "0000"));
        w.add(new PersonalCard("", "00043"));        
        ArrayList<String> allCards = w.getAllCardsList();
        assertEquals(5, allCards.size());
        assertEquals("3212321", allCards.get(0));
        assertEquals("321545", allCards.get(1));
        assertEquals("32655", allCards.get(2));
        assertEquals("0000", allCards.get(3));
        assertEquals("00043", allCards.get(4));
    }
    @Test
    public void loadPaymentCardTest(){
        Wallet w = new Wallet();
        w.add(new DebitCard("", "321545", new Bank(543)));
        PaymentCard pc = w.loadPaymentCard("321545");
        assertEquals("321545", pc.getCardNumber());
    }
}

