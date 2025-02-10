package main.java;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditAccount extends BankAccount implements TransactionFee, TransactionValidator {
    private static final BigDecimal CREDIT_LIMIT = new BigDecimal("-5000");
    private static final BigDecimal FEE_RATE = new BigDecimal(0.01);
    public CreditAccount(String accountNumber, BigDecimal balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (!validate(amount)){
            System.out.println("Привышен лимит");
        } else  {
            BigDecimal totalAmount = applyFee(amount);
            if (balance.subtract(totalAmount).compareTo(CREDIT_LIMIT) >= 0) {
                balance = balance.subtract(totalAmount);
            } else {
                System.out.println("Привышение кредитного лимита");
            }
        }
    }

    @Override
    public BigDecimal applyFee(BigDecimal amount) {
        return amount.multiply(BigDecimal.ONE.add(FEE_RATE)).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean validate(BigDecimal amount) {
        return amount.compareTo(new BigDecimal("5000")) <= 0;
    }
}
