package com.example.home.mcheque.accountSummary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by home on 11/04/17.
 */

public class AccountSummary {
    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("balance")
    @Expose
    private String balance;

    @SerializedName("accountno")
    @Expose
    private String accountNo;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
