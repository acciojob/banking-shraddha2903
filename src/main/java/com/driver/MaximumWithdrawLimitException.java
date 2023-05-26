package com.driver;

public class MaximumWithdrawLimitException extends RuntimeException {
    public MaximumWithdrawLimitException(String msg) {
        super(msg);
    }
}
