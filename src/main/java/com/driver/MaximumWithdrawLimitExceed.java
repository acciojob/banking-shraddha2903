package com.driver;

public class MaximumWithdrawLimitExceed extends RuntimeException {
    public MaximumWithdrawLimitExceed(String msg) {
        super(msg);
    }
}
