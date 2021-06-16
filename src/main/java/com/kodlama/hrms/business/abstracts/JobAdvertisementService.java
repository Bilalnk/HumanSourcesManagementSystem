package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;

import java.util.List;
import java.util.Optional;

public interface JobAdvertisementService{

    DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>> findByActiveTrue();

    DataResult<List<JobAdvertisement>> findByActiveTrueOrderByPublishedDateDesc();

    DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployerId(int employerId);

     Result updateAdvertisementActive(int id, boolean active);

     DataResult<List<JobAdvertisementDto>> getJobAdveritsementDetails();

     DataResult<Optional<JobAdvertisement>> getById(int id);



}
