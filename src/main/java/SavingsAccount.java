package main.java;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount extends BankAccount implements InterestBearing{
    public SavingsAccount(String accountNumber, BigDecimal balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }
    private static final BigDecimal INSERT_RATE = new BigDecimal(0.05);

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) <= 0) {
            balance = balance.subtract(amount);
        } else {
            System.out.println("Недостаточно средств");
        }
    }

    @Override
    public void applyInterest() {
        balance = balance.add(balance.multiply(INSERT_RATE).setScale(2, RoundingMode.HALF_UP));
    }
}
