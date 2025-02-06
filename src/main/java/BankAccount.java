package main.java;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected String accountHolder;

    public BankAccount(String accountNumber, double balance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }
    public abstract void withdraw (double amount);

    public void deposit (double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public double getBalance() {
        return balance;
    }
}
