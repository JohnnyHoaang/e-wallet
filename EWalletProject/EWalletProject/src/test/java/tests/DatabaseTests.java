package tests;



import org.junit.Test;
import static org.junit.Assert.*;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mycompany.ewalletproject.App;
import com.mycompany.ewalletproject.storage.Database;
import com.mycompany.ewalletproject.storage.Wallet;
import com.mycompany.ewalletproject.walletitems.CustomDate;
import com.mycompany.ewalletproject.walletitems.Note;

public class DatabaseTests{
    // to run unit tests, insert pass your credentials into the variables below
    String user = "";
    String password = "";
    @Test
    public void loadWalletsTest() throws SQLException{
        Database db = new Database();
        Wallet w = new Wallet();
        w.add(new Note(new CustomDate("09/11"), "HELLO"));
        w.add(new Note(new CustomDate("01/23"), "HI"));
        w.add(new Note(new CustomDate("43/12"), "lol"));
        db.save(w);
        String text = "";
        String sql = "Select text from note where note_id=0";
        PreparedStatement prep = App.getConnection().prepareStatement(sql);
        ResultSet rs = prep.executeQuery();
        if(rs.next()){
            text = rs.getString(1);
        }
        assertEquals(w.getIWalletItem(0), text);
    }
}
