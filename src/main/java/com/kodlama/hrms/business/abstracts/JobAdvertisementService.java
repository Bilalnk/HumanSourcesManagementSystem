package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService{

    DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>> findByActiveTrue();

    DataResult<List<JobAdvertisement>> findByActiveTrueOrderByPublishedDateDesc();

    DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployerId(int employerId);

     Result updateAdvertisementActive(int id, boolean active);



}
