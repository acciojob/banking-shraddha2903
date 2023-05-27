package com.driver;

public class AccountNumberCanNotBeGenerated extends RuntimeException {
    public AccountNumberCanNotBeGenerated(String msg) {
        super(msg);
    }
}
