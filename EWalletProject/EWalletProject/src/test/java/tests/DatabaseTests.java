package tests;



import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import com.mycompany.ewalletproject.storage.Database;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.CustomDate;
import com.mycompany.ewalletproject.walletitems.Note;

public class DatabaseTests{
    @Test
    public void loadWalletsTest(){
        Database db = new Database();
        Wallet w = new Wallet();
        w.add(new Note(new CustomDate("09/11"), "HELLO"));
        w.add(new Note(new CustomDate("01/23"), "HI"));
        w.add(new Note(new CustomDate("43/12"), "lol"));
        db.save(w);
        ArrayList<String> notes =db.load(w.getID()).browseNotes();
        assertEquals(3, notes.size());
    }
}
