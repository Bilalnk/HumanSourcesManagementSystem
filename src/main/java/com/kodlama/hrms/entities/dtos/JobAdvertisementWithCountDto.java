package com.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementWithCountDto {

    private int jobCount;
    private List<JobAdvertisementDto> jobAdvertisementDto;


}
