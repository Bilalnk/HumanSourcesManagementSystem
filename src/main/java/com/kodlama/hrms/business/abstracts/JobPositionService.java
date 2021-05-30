package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.entities.concretes.JobPositions;

import java.util.List;
import java.util.Optional;

public interface JobPositionService {

    DataResult<List<JobPositions>> getAll();

    DataResult<Optional<JobPositions>> getById(int id);

    DataResult<List<JobPositions>> getByName(String position);

    DataResult<JobPositions> saveJobPosition(JobPositions jobPositions);

    SuccessResult delete(int id);

    DataResult<JobPositions> updateById(int id, JobPositions jobPositions);


}
