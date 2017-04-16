package com.example.home.mcheque.participantDataMapping;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roman on 14/4/17.
 */

public class Accounts {
//    @SerializedName("account_no")
//    @Expose
//    private String accountNo;
//
//    @SerializedName("cust_id")
//    @Expose
//    private String custId;
//
//    @SerializedName("treasury_userid")
//    @Expose
//    private String treasuryUserId;
//
//    @SerializedName("treasury_cust_id")
//    @Expose
//    private String treasuryCustId;
//
//    @SerializedName("rmmobile")
//    @Expose
//    private String rMobile;
//
//    @SerializedName("Policy No")
//    @Expose
//    private String policyNo;
//
//    public String getAccountNo() {
//        return accountNo;
//    }
//
//    public void setAccountNo(String accountNo) {
//        this.accountNo = accountNo;
//    }
//
//    public String getCustId() {
//        return custId;
//    }
//
//    public void setCustId(String custId) {
//        this.custId = custId;
//    }
//
//    public String getPolicyNo() {
//        return policyNo;
//    }
//
//    public void setPolicyNo(String policyNo) {
//        this.policyNo = policyNo;
//    }
//
//    public void setTreasuryCustId(String treasuryCustId) {
//        this.treasuryCustId = treasuryCustId;
//    }
//
//    public String getTreasuryCustId() {
//        return treasuryCustId;
//    }
//
//    public void setTreasuryUserId(String treasuryUserId) {
//        this.treasuryUserId = treasuryUserId;
//    }
//
//    public String getTreasuryUserId() {
//        return treasuryUserId;
//    }
//
//    public void setrMobile(String rMobile) {
//        this.rMobile = rMobile;
//    }
//
//    public String getrMobile() {
//        return rMobile;
//    }

    @SerializedName("debit card no")
    @Expose
    private String debitCardNo;

    @SerializedName("loan account_no")
    @Expose
    private String loanAccountNo;

    @SerializedName("securities_scheme_id")
    @Expose
    private String securitiesSchemeId;

    @SerializedName("cust_id")
    @Expose
    private String custId;

    @SerializedName("account_no")
    @Expose
    private String accountNo;

    @SerializedName("treasury_currency_pair")
    @Expose
    private String treasuryCurrencyPair;

    @SerializedName("treasury_userid")
    @Expose
    private String treasuryUserid;

    @SerializedName("treasury_cust_id")
    @Expose
    private String treasuryCustId;

    @SerializedName("corpid")
    @Expose
    private String corpid;

    @SerializedName("ucc")
    @Expose
    private String ucc;

    @SerializedName("custid")
    @Expose
    private String custid;

    @SerializedName("rmmobile")
    @Expose
    private String rmmobile;

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("Policy No")
    @Expose
    private String policyNo;

    @SerializedName("Policy Holder Pan No")
    @Expose
    private String policyHolderPanNo;

    @SerializedName("Policy Holder Email Address")
    @Expose
    private String policyHolderEmailAddress;

    @SerializedName("Policy Holder Dob")
    @Expose
    private String policyHolderDob;

    @SerializedName("Policy Holder Mobile no")
    @Expose
    private String policyHolderMobileNo;
//    @SerializedName
//    @Expose
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDebitCardNo() {
        return debitCardNo;
    }

    public void setDebitCardNo(String debitCardNo) {
        this.debitCardNo = debitCardNo;
    }

    public String getLoanAccountNo() {
        return loanAccountNo;
    }

    public void setLoanAccountNo(String loanAccountNo) {
        this.loanAccountNo = loanAccountNo;
    }

    public String getSecuritiesSchemeId() {
        return securitiesSchemeId;
    }

    public void setSecuritiesSchemeId(String securitiesSchemeId) {
        this.securitiesSchemeId = securitiesSchemeId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTreasuryCurrencyPair() {
        return treasuryCurrencyPair;
    }

    public void setTreasuryCurrencyPair(String treasuryCurrencyPair) {
        this.treasuryCurrencyPair = treasuryCurrencyPair;
    }

    public String getTreasuryUserid() {
        return treasuryUserid;
    }

    public void setTreasuryUserid(String treasuryUserid) {
        this.treasuryUserid = treasuryUserid;
    }

    public String getTreasuryCustId() {
        return treasuryCustId;
    }

    public void setTreasuryCustId(String treasuryCustId) {
        this.treasuryCustId = treasuryCustId;
    }

    public String getCorpid() {
        return corpid;
    }

    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }

    public String getUcc() {
        return ucc;
    }


    public void setUcc(String ucc) {
        this.ucc = ucc;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getRmmobile() {
        return rmmobile;
    }

    public void setRmmobile(String rmmobile) {
        this.rmmobile = rmmobile;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyHolderPanNo() {
        return policyHolderPanNo;
    }

    public void setPolicyHolderPanNo(String policyHolderPanNo) {
        this.policyHolderPanNo = policyHolderPanNo;
    }

    public String getPolicyHolderEmailAddress() {
        return policyHolderEmailAddress;
    }

    public void setPolicyHolderEmailAddress(String policyHolderEmailAddress) {
        this.policyHolderEmailAddress = policyHolderEmailAddress;
    }

    public String getPolicyHolderDob() {
        return policyHolderDob;
    }

    public void setPolicyHolderDob(String policyHolderDob) {
        this.policyHolderDob = policyHolderDob;
    }

    public String getPolicyHolderMobileNo() {
        return policyHolderMobileNo;
    }

    public void setPolicyHolderMobileNo(String policyHolderMobileNo) {
        this.policyHolderMobileNo = policyHolderMobileNo;
    }

//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
}
