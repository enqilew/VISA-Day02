package workshop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccount {
    // Private members
    private final String accountName;               // Read-only property
    private final String accountNumber;             // Read-only property
    private float accountBalance;
    private final List<String> transactions;        // List to hold transactions
    private boolean closed;                         // Indicates if the account is closed
    private final LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;   // Can be set when account is closed


    // First constructor with only accountName
    public BankAccount(String accountName) {
        this.accountName = accountName;
        this.accountNumber = generateAccountNumber();           // Randomly generated account number
        this.accountBalance = 0.0f;                             // Initial balance set to 0
        this.transactions = new ArrayList<>();
        this.closed = false;                                    // Account is open by default
        this.accountCreationDate = LocalDateTime.now();     // Current time as creation time
    }

    // Second constructor with accountName and initla balance
    public BankAccount(String accountName, float initialBalance) {
        this.accountName = accountName;
        this.accountNumber = generateAccountNumber();
        this.accountBalance = initialBalance;
        this.transactions = new ArrayList<>();
        this.closed = false;
        this.accountCreationDate = LocalDateTime.now();
    }

    // Private method to generate AccountNumber (simulated as a string)
    private String generateAccountNumber() {
        Random rand = new Random();
        int accountNum = 100000 + rand.nextInt(900000);    // Generates a random 6-digit number
        return String.valueOf(accountNum);
    }

    // Getters only
    // Designed to be immutable and should not be modified after initialization
    // Preventing changes ensures that critical information remains consistent throughout the lifetime of the account
    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    // Method to deposit money
    public void deposit(float amount) {
        if (amount <= 0 || closed) {
            throw new IllegalArgumentException("Invalid amount or the account is closed.");
        }
        accountBalance += amount;
        String transaction = "Deposit $" + amount +" at " + LocalDateTime.now(); 
        transactions.add(transaction);              // Add deposit transaction to the list
    }

    // Method to withdraw money
    public void withdraw(float amount) {
        if (amount <= 0 || closed || amount > accountBalance) {
            throw new IllegalArgumentException("Invalid amount, insufficient funds, or account is closed");
        }
        accountBalance -= amount;
        String transaction = "Withdraw $" + amount + " at " + LocalDateTime.now();
        transactions.add(transaction);              // Add withdraw transaction to the list
    }

    // Method to close the account
    public void closeAccount() {
        if (!closed) {
            closed = true;                                      // Becomes true
            accountClosingDate = LocalDateTime.now();       // Set the closing date
            transactions.add("Account closed at " + accountClosingDate);
        } else {
            throw new IllegalArgumentException("The account is already closed.");
        }
    }

    // Mehtod to check if the account is closed
    public boolean isClosed() {
        return closed;
    }
}

