package main.java;

public class SavingsAccount extends BankAccount implements InterestBearing{
    public SavingsAccount(String accountNumber, double balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }
    private static final double INSERT_RATE = 0.05;

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств");
        }
    }

    @Override
    public void applyInterest() {
        balance += balance * INSERT_RATE;
    }
}
