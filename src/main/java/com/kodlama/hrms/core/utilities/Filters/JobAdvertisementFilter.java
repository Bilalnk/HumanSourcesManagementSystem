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




}
