

import org.junit.Test;
import static org.junit.Assert.*;

import com.mycompany.ewalletproject.walletitems.Bank;
import com.mycompany.ewalletproject.walletitems.DebitCard;

public class DebitCardTests {
    @Test
    public void checkFundsTrueTest(){
        DebitCard db = new DebitCard("Joe", "4516165", new Bank(5000));
        boolean check = db.checkFundsAvailability(2000);
        assertEquals(check, true);
    }
    @Test
    public void checkFundsFalseTest(){
        DebitCard db = new DebitCard("Joe", "4516165", new Bank(5000));
        boolean check = db.checkFundsAvailability(5500);
        assertEquals(check, false);
    }
    @Test
    public void withdrawAmountTrueTest(){
        DebitCard db = new DebitCard("Joe", "4516165", new Bank(5000));
        boolean check = db.withdraw(2000);
        assertEquals(check, true);
        assertEquals(db.getBank().getAmount(), 3000);
    }
    @Test
    public void withdrawAmountFalseTest(){
        DebitCard db = new DebitCard("Joe", "4516165", new Bank(5000));
        boolean check = db.withdraw(5001);
        assertEquals(check, false);
        assertEquals(db.getBank().getAmount(), 5000);
    }

}
