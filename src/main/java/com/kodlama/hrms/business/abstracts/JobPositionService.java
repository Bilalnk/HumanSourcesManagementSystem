package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.entities.concretes.JobPositions;

import java.util.List;
import java.util.Optional;

public interface JobPositionService {

    List<JobPositions> getAll();

    Optional<JobPositions> getById(int id);

    List<JobPositions> getByName(String position);

    JobPositions saveJobPosition(JobPositions jobPositions);

    void delete(int id);

    JobPositions updateById(int id, JobPositions jobPositions);


}
