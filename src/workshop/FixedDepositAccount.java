package workshop;

public class FixedDepositAccount extends BankAccount{
    
    // Additional members for FixedDepositAccount
    private float interest;
    private int duration;
    private boolean interestAndDurationSet; // To ensure that interest and duration are set only once

    // Default values
    private static final float defaultInterest = 3.0f;
    private static final int defaultDuration= 6;

    // Constructor 1: Takes name and balance
    public FixedDepositAccount (String name, float balance) {
        super(name, balance);
        this.interest = defaultInterest;
        this.duration = defaultDuration;
        this.interestAndDurationSet = false;
    }

    //  Constructor 2: Takes name, balance, and interest 
    public FixedDepositAccount (String name, float balance, float interest) {
        super(name, balance);
        setInterestAndDuration(interest, defaultDuration);
    }

    // Constructor 3: Takes name, balance, interest and duration
    public FixedDepositAccount (String name, float balance, float interest, int duration) {
        super(name, balance);
        setInterestAndDuration(interest, duration);
    }

    // Mehtod to set interest and duration, only allowed once
    void setInterestAndDuration(float interest, int duration) {
        if (this.interestAndDurationSet) {
            throw new IllegalArgumentException("Interest and duration can only be set once.");  
        }
        this.interest = interest;
        this.duration = duration;
        this.interestAndDurationSet = true;             // Lock the ability to set again
    }

    // Override deposit() method to do nothing (NOP)
    @Override
    public void deposit(float amount) {
        // NOP - No operation
        System.out.println("Deposits are not allowed in FixedDepositAccoount.");
    } 

    // Override withdraw() method to do nothing (NOP)
    @Override
    public void withdraw(float amount) {
        System.out.println("Withdrawals are not allowed in FixedDepositAccount.");
    }

    // Override getBalance() method to return balance plus  interest
    @Override
    public float getAccountBalance() {
        //// Apply interest based on duration (e.g., duration in months)
        //float totalInterest = super.getAccountBalance() * (interest / 100) * (duration / 12);  // Adjust interest for duration
        //return super.getAccountBalance() + totalInterest;
        
        // Compound interest formula: A = P (1 + r/n)^(nt)
        float finalBalance = super.getAccountBalance() * (float) Math.pow((1 + (interest / 100)), (duration / 12));  // Compounds over duration
            return finalBalance;
    }

    // Getters for interest and duration
    public float getInterest() {
        return interest;
    }

    public int getDuration() {
        return duration;
    }
    
}
