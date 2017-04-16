package com.example.home.mcheque.payeeList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mayu on 14-04-2017.
 */

public class Payee {

    @SerializedName("code")
    @Expose
    private int code;
    public int getCode() {
        return code;
    }
    public void setCode(int  code) {
        this.code = code;
    }


    @SerializedName("creationdate")
    @Expose
    private String creationdate;
    public String getCreationdate() {
        return creationdate;
    }
    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    @SerializedName("custid")
    @Expose
    private String custId;
    public String getCustomerId() {
        return custId;
    }
    public void setCustomerId(String custId) {
        this.custId = custId;
    }

    @SerializedName("payeeid")
    @Expose
    private String payeeId;
    public String getPayeeId() {
        return payeeId;
    }
    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    @SerializedName("payeename")
    @Expose
    private String payeeName;
    public String getPayeeName() {
        return payeeName;
    }
    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    @SerializedName("payeeaccountno")
    @Expose
    private String payeeAccountNo;
    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }
    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo;
    }

    @SerializedName("shortname")
    @Expose
    private String payeeShortName;
    public String getPayeeShortName() {
        return payeeShortName;
    }
    public void setPayeeShortName(String payeeShortName) {
        this.payeeShortName = payeeShortName;
    }

    public Payee(){}

    public Payee(String custId, String payeeId, String payeeAccountNo, String payeeName, String payeeShortName){
        this.custId = custId;
        this.payeeId = payeeId;
        this.payeeAccountNo = payeeAccountNo;
        this.payeeName = payeeName;
        this.payeeShortName = payeeShortName;
    }
}
