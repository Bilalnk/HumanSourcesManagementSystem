package com.kodlama.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolInfoDto {

    private int id;
    private int schoolId;
    private int departmentId;

    private Date finishDate;

    private Date startDate;

}
