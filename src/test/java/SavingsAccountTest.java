package test.java;
import main.java.SavingsAccount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @Before
    public void setUp() {
        savingsAccount = new SavingsAccount("account123 ", 2000.0, "Charlie");
    }

    @Test
    public void testApplyInterest() {
        savingsAccount.applyInterest();
        assertEquals(2100.0, savingsAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        savingsAccount.withdraw(500.0);
        assertEquals(1500.0, savingsAccount.getBalance(), 0.001);
    }
}
