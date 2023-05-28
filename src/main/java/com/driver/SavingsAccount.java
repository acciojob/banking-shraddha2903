package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        // minimum balance is 0 by default

    }
    public void withdraw(double amount) throws InsufficientBalanceException,MaximumWithdrawLimitExceed {
        if(amount > super.getBalance())
        {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        if(amount>maxWithdrawalLimit)
            throw new MaximumWithdrawLimitExceed("Maximum Withdraw Limit Exceeded");

        super.setBalance(super.getBalance()-amount);
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        double interest = ((super.getBalance())*(this.rate)*(years))/100.0;
        return interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year

        double p=super.getBalance();
        double pr=Math.pow(1+(rate/times),years*times);
        double ci = p*pr-p;
        return ci;
    }

}
