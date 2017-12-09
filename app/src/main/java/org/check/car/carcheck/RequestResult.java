
package org.check.car.carcheck;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestResult {

    @SerializedName("ownershipPeriods")
    @Expose
    private OwnershipPeriods ownershipPeriods;
    @SerializedName("vehiclePassport")
    @Expose
    private VehiclePassport vehiclePassport;
    @SerializedName("vehicle")
    @Expose
    private Vehicle vehicle;

    public OwnershipPeriods getOwnershipPeriods() {
        return ownershipPeriods;
    }

    public void setOwnershipPeriods(OwnershipPeriods ownershipPeriods) {
        this.ownershipPeriods = ownershipPeriods;
    }

    public VehiclePassport getVehiclePassport() {
        return vehiclePassport;
    }

    public void setVehiclePassport(VehiclePassport vehiclePassport) {
        this.vehiclePassport = vehiclePassport;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
