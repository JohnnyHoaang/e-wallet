package tests;



import org.junit.Test;
import static org.junit.Assert.*;

import com.mycompany.ewalletproject.walletitems.CustomDate;
import com.mycompany.ewalletproject.walletitems.Note;

public class NoteTests {
    @Test
    public void getTextTest(){
        Note note = new Note(new CustomDate("12/11"), "hello world");
        assertEquals(note.getText(), "hello world");
    }
    @Test
    public void getNoteID(){
        Note first = new Note(new CustomDate("12/11"), "first");
        Note second = new Note(new CustomDate("12/11"), "second");
        Note third = new Note(new CustomDate("12/11"), "third");
        assertEquals(first.getID(),0);
        assertEquals(second.getID(),1);
        assertEquals(third.getID(),2);
    }
}
