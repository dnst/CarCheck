
package org.check.car.carcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OwnershipPeriod {

    @SerializedName("lastOperation")
    @Expose
    private String lastOperation;
    @SerializedName("simplePersonType")
    @Expose
    private String simplePersonType;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;

    public String getLastOperation() {
        return lastOperation;
    }

    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }

    public String getSimplePersonType() {
        return simplePersonType;
    }

    public void setSimplePersonType(String simplePersonType) {
        this.simplePersonType = simplePersonType;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
