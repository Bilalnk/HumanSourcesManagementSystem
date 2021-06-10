package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateSchoolInfo;
import com.kodlama.hrms.entities.concretes.Experience;

import java.util.List;

public interface CandidateSchoolInfoService {

    Result add(CandidateSchoolInfo candidateSchoolInfo);

    DataResult<List<CandidateSchoolInfo>> getAll();

    DataResult<List<CandidateSchoolInfo>> getByCandidatesIdOrderByDateOfFinishDesc(int candidateId);

}
