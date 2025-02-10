package test.java;
import main.java.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

public class TransactionProcessorTest {
    private TransactionProcessor processor;
    private List<BankAccount> accounts;
    private static final BigDecimal DELTA = new BigDecimal(0.01);

    @Before
    public void setUp() {
        processor = new TransactionProcessor();
        accounts = List.of(
                new DebitAcoount("Account111", new BigDecimal(1000.0), "Amiran"),
                new CreditAccount("Account222", new BigDecimal(0.0), "Alex"),
                new SavingsAccount("Account333", new BigDecimal(2000.0), "Alina")
        );
    }

    @Test
    public void testProcessTransactions() {
        processor.processTransaction(accounts, new BigDecimal(200.0));
        assertEquals(new BigDecimal(800.0), accounts.get(0).getBalance(), DELTA);
        assertEquals(new BigDecimal(-202.0), accounts.get(1).getBalance(), DELTA);
        assertEquals(new BigDecimal(1800.0), accounts.get(2).getBalance(), DELTA);
    }
}
