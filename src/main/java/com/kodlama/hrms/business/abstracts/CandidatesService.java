package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Candidates;
import com.kodlama.hrms.entities.dtos.CVDto;
import com.kodlama.hrms.entities.dtos.CvPersonalInfoDto;

import java.util.List;
import java.util.Optional;

public interface CandidatesService {

    DataResult<List<Candidates>> getAll();

    DataResult<Optional<Candidates>> getById(int id);

    Result add (Candidates candidates);

    Result update (CvPersonalInfoDto cvPersonalInfoDto);

    boolean isExist(int id);

    DataResult<CVDto> getCvById(int id);
}
