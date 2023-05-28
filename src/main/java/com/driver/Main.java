package com.driver;

public class Main {
    public static void main(String[] args) throws InValidLicenseIdException {

       CurrentAccount currentAccount = new CurrentAccount("curr", 10000.0, "ABC");
        currentAccount.validateLicenseId();
        System.out.println(currentAccount.getTradeLicenseId());


    }
}