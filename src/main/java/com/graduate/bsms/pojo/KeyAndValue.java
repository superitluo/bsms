package com.graduate.bsms.pojo;

import java.io.Serializable;

/**
 * Created by Admin on 2018/5/22.
 */
public class KeyAndValue implements Serializable {
    private String mkey;
    private String mvalue;

    public KeyAndValue() {
    }

    public KeyAndValue(String mkey, String mvalue) {
        this.mkey = mkey;
        this.mvalue = mvalue;
    }

    public String getMkey() {
        return mkey;
    }

    public void setMkey(String mkey) {
        this.mkey = mkey;
    }

    public String getMvalue() {
        return mvalue;
    }

    public void setMvalue(String mvalue) {
        this.mvalue = mvalue;
    }

    @Override
    public String toString() {
        return "KeyAndValue{" +
                "mkey='" + mkey + '\'' +
                ", mvalue='" + mvalue + '\'' +
                '}';
    }
}
