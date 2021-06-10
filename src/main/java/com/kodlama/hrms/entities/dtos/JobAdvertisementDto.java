package com.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

    private int id;
    private String employerName;
    private String jobPositionName;
    private int openPosition;
    private Date publishedDate;
    private Date lastDateToApply;
}
