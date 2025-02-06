package test.java;
import main.java.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class TransactionProcessorTest {
    private TransactionProcessor processor;
    private List<BankAccount> accounts;

    @Before
    public void setUp() {
        processor = new TransactionProcessor();
        accounts = Arrays.asList(
                new DebitAcoount("Account111", 1000.0, "Amiran"),
                new CreditAccount("Account222", 0.0, "Alex"),
                new SavingsAccount("Account333", 2000.0, "Alina")
        );
    }

    @Test
    public void testProcessTransactions() {
        processor.processTransaction(accounts, 200.0);
        assertEquals(800.0, accounts.get(0).getBalance(), 0.001);
        assertEquals(-202.0, accounts.get(1).getBalance(), 0.001);
        assertEquals(1800.0, accounts.get(2).getBalance(), 0.001);
    }
}
