import main.java.DebitAcoount;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public class DebitAccountTest {
    private DebitAcoount debitAcoount;
    private static final BigDecimal DELTA = new BigDecimal(0.01);

    @Before
    public void setUp() {
        debitAcoount = new DebitAcoount("Account213", new BigDecimal(1000.00), "Victor");
    }

    @Test
    public void testWithdrawSuccess(){
        debitAcoount.withdraw(new BigDecimal(500.00));
        assertEquals(new BigDecimal(500.00), debitAcoount.getBalance(), DELTA);
    }


    @Test
    public void testReceiptOfDeposit() {
        debitAcoount.deposit(new BigDecimal(200.00));
        assertEquals(new BigDecimal(1200.00), debitAcoount.getBalance(), DELTA);
    }

    @Test
    public void testTransactionValidation() {
        debitAcoount.withdraw(new BigDecimal(15000));
        assertEquals(1000.0, debitAcoount.getBalance(), DELTA);
    }
}
