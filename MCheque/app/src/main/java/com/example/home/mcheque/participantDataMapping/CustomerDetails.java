package com.example.home.mcheque.participantDataMapping;

/**
 * Created by roman on 16/4/17.
 */

public class CustomerDetails {
    private String accountNo;
    private String custId;

    public CustomerDetails(){}

    public CustomerDetails(String accountNo,String custId){
        this.accountNo = accountNo;
        this.custId = custId;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustId() {
        return custId;
    }
}
