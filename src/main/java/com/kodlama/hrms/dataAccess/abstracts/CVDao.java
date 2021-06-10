package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.dtos.CVDto;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.Query;

public interface CVDao {

    @Query("select new com.kodlama.hrms.entities.dtos.CVDto() from CandidateSchoolInfo csi inner join csi.candidates inner join ")
    DataResult<CVDto> getCvDetails();
}
