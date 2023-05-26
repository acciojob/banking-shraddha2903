package com.driver;

public class AccountNumberCanNotGenerated extends RuntimeException {
    public AccountNumberCanNotGenerated(String msg) {
        super(msg);
    }
}
