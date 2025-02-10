package test.java;
import main.java.CreditAccount;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public class CreditAccountTest {
    private CreditAccount creditAccount;
    private static final BigDecimal DELTA = new BigDecimal(0.01);

    @Before
    public void setUp() {
        creditAccount = new CreditAccount("Account123", new BigDecimal(-2000.0), "Anna");
    }

    @Test
    public void testWithdrawWithFee() {
        creditAccount.withdraw(new BigDecimal(2000.0));
        assertEquals(new BigDecimal(-4020.0), creditAccount.getBalance(), DELTA);
    }

    @Test
    public void testExceedCreditLimit() {
        creditAccount.withdraw(new BigDecimal(4000.0));
        assertEquals(new BigDecimal(-2000.0), creditAccount.getBalance(), DELTA);
    }

    @Test
    public void testApplyFeeCalculation() {
        assertEquals(new BigDecimal(5050.0), creditAccount.applyFee(new BigDecimal(5000.0)), DELTA);
    }

    @Test
    public void testTransactionValidation() {
        creditAccount.withdraw(new BigDecimal(6000));
        assertEquals(new BigDecimal(-2000.0), creditAccount.getBalance(), DELTA);
    }
}