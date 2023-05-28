package com.driver;

public class Main {
    public static void main(String[] args) throws InValidLicenseIdException {

        SavingsAccount savingsAccount = new SavingsAccount("save", 0.0, 5.0, 50.0);
       // savingsAccount.withdraw(1.0);
        System.out.println("Balance  :"+savingsAccount.getBalance());

        savingsAccount.deposit(500.0);
        System.out.println("Balance  :"+savingsAccount.getBalance());

        savingsAccount.withdraw(1.0);
        System.out.println("Balance  :"+savingsAccount.getBalance());
        System.out.println(savingsAccount.getMaxWithdrawalLimit());
        //savingsAccount.withdraw(400);
        SavingsAccount savingsAccount1 = new SavingsAccount("acc1", 5500.0, 1.0, 20.0);
        Double diff = savingsAccount1.getCompoundInterest(12, 2) - 8178.033;
        System.out.println("Difff: "+diff);

        SavingsAccount savingsAccount2 = new SavingsAccount("acc1", 1000.0, 1.0, 10.0);
        Double diff1 = savingsAccount2.getSimpleInterest(5) - 1500.0;
        System.out.println("Difff: "+diff1);

        SavingsAccount savingsAccount3 = new SavingsAccount("acc1", 1000.0, 1.0, 5.0);
        Double diff2 = savingsAccount3.getCompoundInterest(2, 10) - 1638.52;
        System.out.println("Difff: "+diff2);

    }
}