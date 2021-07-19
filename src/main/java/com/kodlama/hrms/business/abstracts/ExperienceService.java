package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {

    Result add(Experience experience);

    DataResult<List<Experience>> getAll();

    DataResult<List<Experience>> findByCandidatesIdOrderByDepartureDateDesc(int candidateId);

    Result delete (int id);
}
