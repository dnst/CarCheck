
package org.check.car.carcheck;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OwnershipPeriods {

    @SerializedName("ownershipPeriod")
    @Expose
    private List<OwnershipPeriod> ownershipPeriod = null;

    public List<OwnershipPeriod> getOwnershipPeriod() {
        return ownershipPeriod;
    }

    public void setOwnershipPeriod(List<OwnershipPeriod> ownershipPeriod) {
        this.ownershipPeriod = ownershipPeriod;
    }

}
