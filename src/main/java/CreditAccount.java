package main.java;

public class CreditAccount extends BankAccount implements TransactionFee, TransactionValidator {
    private static final double CREDIT_LIMIT = -5000;
    private static final double FEE_RATE = 0.01;
    public CreditAccount(String accountNumber, double balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(double amount) {
        if (!validate(amount)){
            System.out.println("Привышен лимит");
        } else  {
            double totalAmount = applyFee(amount);
            if (balance - totalAmount >= CREDIT_LIMIT) {
                balance -= totalAmount;
            } else {
                System.out.println("Привышение кредитного лимита");
            }
        }

    }

    @Override
    public double applyFee(double amount) {
        return amount * (1 + FEE_RATE);
    }

    @Override
    public boolean validate(double amount) {
        return amount <= 5000;
    }
}
