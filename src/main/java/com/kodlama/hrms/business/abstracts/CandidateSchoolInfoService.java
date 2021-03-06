package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateSchoolInfo;
import com.kodlama.hrms.entities.concretes.Experience;
import com.kodlama.hrms.entities.dtos.SchoolInfoDto;

import java.util.List;

public interface CandidateSchoolInfoService {

    Result add(CandidateSchoolInfo candidateSchoolInfo);

    DataResult<List<CandidateSchoolInfo>> getAll();

    DataResult<List<CandidateSchoolInfo>> getByCandidatesIdOrderByDateOfFinishDesc(int candidateId);

    Result update(SchoolInfoDto schoolInfoDto);

    Result deleteById(int id);

}
