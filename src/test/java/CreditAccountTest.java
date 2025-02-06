package test.java;
import main.java.CreditAccount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreditAccountTest {
    private CreditAccount creditAccount;

    @Before
    public void setUp() {
        creditAccount = new CreditAccount("Account123", -2000.0, "Anna");
    }

    @Test
    public void testWithdrawWithFee() {
        creditAccount.withdraw(2000.0);
        assertEquals(-4020.0, creditAccount.getBalance(), 0.001);
    }

    @Test
    public void testExceedCreditLimit() {
        creditAccount.withdraw(4000.0);
        assertEquals(-2000.0, creditAccount.getBalance(), 0.001);
    }

    @Test
    public void testApplyFeeCalculation() {
        assertEquals(5050.0, creditAccount.applyFee(5000.0), 0.001);
    }

    @Test
    public void testTransactionValidation() {
        creditAccount.withdraw(6000);
        assertEquals(-2000.0, creditAccount.getBalance(), 0.001);


    }
}