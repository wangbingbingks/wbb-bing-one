package com.product.sc.proto.invoice;

import java.io.Serializable;

public class WorkKey implements Serializable {

    private String workKey;

    public WorkKey() {
    }

    public String getWorkKey() {
        return workKey;
    }

    public void setWorkKey(String workKey) {
        this.workKey = workKey;
    }
}
