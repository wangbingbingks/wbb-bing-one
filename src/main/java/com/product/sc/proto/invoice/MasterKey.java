package com.product.sc.proto.invoice;

import java.io.Serializable;

public class MasterKey implements Serializable {

    private String masterKey;

    public MasterKey() {
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }
}
