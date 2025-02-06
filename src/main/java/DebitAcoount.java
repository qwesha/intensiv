package main.java;

public class DebitAcoount extends BankAccount implements TransactionValidator {
    public DebitAcoount(String accountNumber, double balance, String accountHolder) {
        super(accountNumber, balance, accountHolder);
    }

    @Override
    public void withdraw(double amount) {
        if (validate(amount)) {         // Задача 4 доп
            if (amount > 0) {
                balance -= amount;
            } else {
                System.out.println("Недостаточно средств");
            }
        } else {
            System.out.println("Привышен лимит");
        }

    }

    // Задача 4 доп
    @Override
    public boolean validate(double amount) {
        return amount <= 10000;
    }
}
