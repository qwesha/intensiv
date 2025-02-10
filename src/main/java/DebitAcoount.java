package main.java;
import java.math.BigDecimal;

public class DebitAcoount extends BankAccount implements TransactionValidator {
    public DebitAcoount(String accountNumber, BigDecimal balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (validate(amount)) {         // Задача 4 доп
            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                balance = balance.add(amount);
            } else {
                System.out.println("Недостаточно средств");
            }
        } else {
            System.out.println("Привышен лимит");
        }

    }

    @Override
    public boolean validate(BigDecimal amount) {
        return amount.compareTo(new BigDecimal("10000")) <= 0;
    }
}
