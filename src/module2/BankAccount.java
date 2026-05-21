package module2;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
    	this.balance = initialBalance;
    }
    // Deposit
    public void deposit(double amount) {
    	balance += amount;
    }
    // Withdraw
    public void withdraw(double amount) {
    	balance -= amount;
    }
    // Getter for balance
    public double getBalance() {
    	return balance;
    }
}