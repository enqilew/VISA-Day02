package workshop;

public class Main {
    public static void main(String[] args) {
        // Create a new account with initial balance
        BankAccount account = new BankAccount("John Doe", 500.0f);

        // Deposit money
        account.deposit(200.0f);
        System.out.println("Balance after deposit: $" + account.getAccountBalance());

        // Withdraw money
        account.withdraw(100.0f);
        System.out.println("Balance after withdrawal: $" + account.getAccountBalance());

        // Close the account
        // account.closeAccount();
        
        // Try to withdraw from a closed account (this will throw an exception)
        account.withdraw(50.0f);

        // Print all transactions
        System.out.println("Transaction history: " + account.getTransactions());


        // Create an instance of FixedDepositAccount with default interest and duration
        FixedDepositAccount fd1 = new FixedDepositAccount("John Doe", 1000);
        System.out.println("Account Holder: " + fd1.getAccountName());
        System.out.println("Initial Balance: " + fd1.getAccountBalance()); // Should show balance + interest

        // Trying to change interest and duration again should throw an exception
        try {
            fd1.setInterestAndDuration(5.0f, 12);
            System.out.println("Account Holder: " + fd1.getAccountName());
            System.out.println("Balance: " + fd1.getAccountBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Should print error message
        }

        // Test no operation for deposit and withdraw
        fd1.deposit(500);
        fd1.withdraw(200);
        
    }

}

