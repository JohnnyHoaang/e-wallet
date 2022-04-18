

import org.junit.Test;
import static org.junit.Assert.*;

import com.mycompany.ewalletproject.walletitems.CreditCard;
import com.mycompany.ewalletproject.walletitems.Date;

public class CreditCardTests {
    @Test
    public void creditCardLimitLowTest(){
        try {
            CreditCard cc = new CreditCard("Joe", "39472398", new Date("12/12"), "320", 400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void creditCardLimitHighTest(){
        try {
            CreditCard cc = new CreditCard("Joe", "39472398", new Date("12/12"), "320", 5100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void withdrawTrueTest(){
        CreditCard cc = new CreditCard("Joe", "39472398", new Date("12/12"), "320", 4000);
        boolean check = cc.withdraw(2000);
        assertEquals(true, check);
    }
    @Test
    public void withdrawFalseTest(){
        CreditCard cc = new CreditCard("Joe", "39472398", new Date("12/12"), "320", 4000);
        boolean check = cc.withdraw(5000);
        assertEquals(false, check);            
    }
    @Test
    public void withdrawNegativeTest(){
        CreditCard cc = new CreditCard("Joe", "39472398", new Date("12/12"), "320", 4000);
        try {
            cc.withdraw(6000);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
