package module2;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    // Withdraw (no overdraft)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
    // Getter for balance
    public double getBalance() {
        return balance;
    }
}