package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        StringBuilder accNo= new StringBuilder("");
        int remainSum=sum;
        if(sum>9*digits || sum<0)
            throw new AccountNumberCanNotBeGenerated("Account number can not be generated");

        for(int i = 0; i< digits; i++)
        {
            int min=Math.min(9,remainSum);
            accNo.append(min);
            remainSum-=min;

        }
        return accNo.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        if(amount>this.balance || (this.balance-amount)<this.minBalance)
            throw new InsufficientBalanceException("Insufficient Balance");
        this.balance-=amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}