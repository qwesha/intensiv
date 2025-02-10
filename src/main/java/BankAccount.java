package main.java;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BankAccount {
    protected String accountNumber;
    protected BigDecimal balance;
    protected String accountHolder;

    public BankAccount(String accountNumber, BigDecimal balance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }
    public abstract void withdraw (BigDecimal amount);

    public void deposit (BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
        }
    }
    public BigDecimal getBalance() {
        return balance;
    }
}
