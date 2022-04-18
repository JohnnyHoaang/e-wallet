

import org.junit.Test;
import static org.junit.Assert.*;

import com.mycompany.ewalletproject.walletitems.Cash;

public class CashTests {
    @Test
    public void payTestTrue(){
        Cash cash = new Cash(100);
        boolean check = cash.pay(99);
        boolean secondCheck = cash.pay(1);
        assertEquals(true, check);
        assertEquals(true, secondCheck);
    }
    @Test
    public void payTestFalse(){
        Cash cash = new Cash(100);
        boolean check = cash.pay(140);
        assertEquals(false, check);
    }
    @Test
    public void payNegativeAmountTest(){
        Cash cash = new Cash(100);
        try {
            cash.pay(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void payHighAmountFalseTest(){
        Cash cash = new Cash(100);
        try {
            cash.pay(150);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void firstCashConstructorTest(){
        Cash c = new Cash();
        assertEquals(0, c.getAmount(),0);
    }
    @Test
    public void secondCashConstriuctorTest(){
        Cash c = new Cash(6);
        assertEquals(6, c.getAmount(),0);
    }
    @Test
    public void copyConstructorTest(){
        Cash c = new Cash(6);
        Cash cc = new Cash(c);
        assertEquals(6, cc.getAmount(),0);
    }

}
