import main.java.DebitAcoount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DebitAccountTest {
    private DebitAcoount debitAcoount;

    @Before
    public void setUp() {
        debitAcoount = new DebitAcoount("Account213", 1000.0, "Victor");
    }

    @Test
    public void testWithdrawSuccess(){
        debitAcoount.withdraw(500.0);
        assertEquals(500.0, debitAcoount.getBalance(), 0.001);
    }


    @Test
    public void testDeposit() {
        debitAcoount.deposit(200.0);
        assertEquals(1200.0, debitAcoount.getBalance(), 0.001);
    }

    @Test
    public void testTransactionValidation() {
        debitAcoount.withdraw(15000);
        assertEquals(1000.0, debitAcoount.getBalance(), 0.001);
    }


}
