package com.kodlama.hrms.core.utilities.Filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAdvertisementFilter {

    private List<Integer> jobPositionId;

    private List<Integer> cityId;

    private List<Integer> wayOfWorkId;

    private List<Integer> workTypeId;

    public boolean isJobPositionIdEmptyOrNull() {
        if (this.jobPositionId != null) {
            return this.jobPositionId.isEmpty();
        }
        return true;
    }

    public boolean isCityIdEmptyOrNull() {
        if (this.cityId != null) {
            return this.cityId.isEmpty();
        }
        return true;
    }

    public boolean isWayOfWorkIdEmptyOrNull() {
        if (this.wayOfWorkId != null) {
            return this.wayOfWorkId.isEmpty();
        }
        return true;
    }

    public boolean isWorkTypeIdEmptyOrNull() {
        if (this.workTypeId != null) {
            return this.workTypeId.isEmpty();
        }
        return true;
    }


}
