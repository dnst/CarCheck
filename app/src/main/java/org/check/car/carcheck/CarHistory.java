
package org.check.car.carcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarHistory {

    @SerializedName("RequestResult")
    @Expose
    private RequestResult requestResult;
    @SerializedName("vin")
    @Expose
    private String vin;
    @SerializedName("regnum")
    @Expose
    private Object regnum;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;

    public RequestResult getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(RequestResult requestResult) {
        this.requestResult = requestResult;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Object getRegnum() {
        return regnum;
    }

    public void setRegnum(Object regnum) {
        this.regnum = regnum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
