
package org.check.car.carcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle {

    @SerializedName("engineVolume")
    @Expose
    private String engineVolume;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("bodyNumber")
    @Expose
    private String bodyNumber;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("engineNumber")
    @Expose
    private String engineNumber;
    @SerializedName("vin")
    @Expose
    private String vin;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("powerHp")
    @Expose
    private String powerHp;
    @SerializedName("powerKwt")
    @Expose
    private String powerKwt;

    public String getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(String engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyNumber() {
        return bodyNumber;
    }

    public void setBodyNumber(String bodyNumber) {
        this.bodyNumber = bodyNumber;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPowerHp() {
        return powerHp;
    }

    public void setPowerHp(String powerHp) {
        this.powerHp = powerHp;
    }

    public String getPowerKwt() {
        return powerKwt;
    }

    public void setPowerKwt(String powerKwt) {
        this.powerKwt = powerKwt;
    }

}
