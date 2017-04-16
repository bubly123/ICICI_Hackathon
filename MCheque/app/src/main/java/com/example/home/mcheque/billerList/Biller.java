package com.example.home.mcheque.billerList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mayu on 16-04-2017.
 */

public class Biller {

    @SerializedName("code")
    @Expose
    private int code;


    public int getCode() {
        return code;
    }
    public void setCode(int  code) {
        this.code = code;
    }


    @SerializedName("BillerDetail")
    @Expose
    private String BillerDetail;
    public String getBillerDetail() {
        return BillerDetail;
    }
    public void setBillerDetail(String BillerDetail) {
        this.BillerDetail = BillerDetail;
    }

    @SerializedName("State")
    @Expose
    private String State;
    public String getState() {
        return State;
    }
    public void setState(String State) {
        this.State = State;
    }

    public Biller(String billerDetail, String state) {

        this.BillerDetail = billerDetail;
        this.State = state;
    }
}
