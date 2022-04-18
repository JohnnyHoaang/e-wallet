package com.mycompany.ewalletproject.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import com.mycompany.ewalletproject.walletitems.Date;
import com.mycompany.ewalletproject.walletitems.Note;

public class NoteTests {
    @Test
    public void getTextTest(){
        Note note = new Note(new Date("12/11"), "hello world");
        assertEquals(note.getText(), "hello world");
    }
    @Test
    public void getNoteID(){
        Note first = new Note(new Date("12/11"), "first");
        Note second = new Note(new Date("12/11"), "second");
        Note third = new Note(new Date("12/11"), "third");
        assertEquals(first.getID(),0);
        assertEquals(second.getID(),1);
        assertEquals(third.getID(),2);
    }
}
