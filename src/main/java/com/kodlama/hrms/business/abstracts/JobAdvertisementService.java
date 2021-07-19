package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.Filters.JobAdvertisementFilter;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;
import com.kodlama.hrms.entities.dtos.JobAdvertisementWithCountDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface JobAdvertisementService{

    DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>> findByActiveTrue();

    DataResult<List<JobAdvertisement>> findByActiveTrueOrderByPublishedDateDesc();

    DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployerId(int employerId);

    Result updateAdvertisementActive(int id, boolean active);

    Result updateAdvertisementConfirmed(int id, boolean active);
     DataResult<List<JobAdvertisementDto>> getJobAdveritsementDetails();

     DataResult<Optional<JobAdvertisement>> getById(int id);

    DataResult<List<JobAdvertisement>> findByConfirmedByEmployeesFalseOrderByPublishedDateDesc();

    DataResult<JobAdvertisementWithCountDto> getTenByTen(JobAdvertisementFilter jobAdvertisementFilter, int pageSize, int pageNo);

    DataResult<List<JobAdvertisement>> getFiltered(JobAdvertisementFilter jobAdvertisementFilter);
}
