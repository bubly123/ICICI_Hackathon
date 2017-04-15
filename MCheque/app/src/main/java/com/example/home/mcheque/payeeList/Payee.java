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

    @SerializedName("token")
    @Expose
    private String token;
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
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
    private String custid;
    public String getCustomerId() {
        return custid;
    }
    public void setCustomerId(String custid) {
        this.custid = custid;
    }

    @SerializedName("payeeId")
    @Expose
    private String payeeId;
    public String getPayeeId() {
        return payeeId;
    }
    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    @SerializedName("payeeName")
    @Expose
    private String payeeName;
    public String getPayeeName() {
        return payeeName;
    }
    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    @SerializedName("payeeAccountNo")
    @Expose
    private String payeeAccountNo;
    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }
    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo;
    }

    @SerializedName("payeeShortName")
    @Expose
    private String payeeShortName;
    public String getPayeeShortName() {
        return payeeShortName;
    }
    public void setPayeeShortName(String payeeShortName) {
        this.payeeShortName = payeeShortName;
    }
}
