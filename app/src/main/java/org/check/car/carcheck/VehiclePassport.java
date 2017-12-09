
package org.check.car.carcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehiclePassport {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("issue")
    @Expose
    private String issue;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

}
