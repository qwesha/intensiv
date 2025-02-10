package test.java;
import main.java.SavingsAccount;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;
    private static final BigDecimal DELTA = new BigDecimal(0.01);

    @Before
    public void setUp() {
        savingsAccount = new SavingsAccount("account123 ", new BigDecimal(2000.0), "Charlie");
    }

    @Test
    public void testApplyInterest() {
        savingsAccount.applyInterest();
        assertEquals(new BigDecimal(2100.0), savingsAccount.getBalance(), DELTA);
    }

    @Test
    public void testWithdraw() {
        savingsAccount.withdraw(new BigDecimal(500.0));
        assertEquals(new BigDecimal(1500.0), savingsAccount.getBalance(), DELTA);
    }
}
