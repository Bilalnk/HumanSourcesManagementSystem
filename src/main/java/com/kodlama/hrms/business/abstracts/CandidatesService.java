package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Candidates;

import java.util.List;
import java.util.Optional;

public interface CandidatesService {

    DataResult<List<Candidates>> getAll();

    DataResult<Optional<Candidates>> getById(int id);

    Result add (Candidates candidates);
}
