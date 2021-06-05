package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateLanguages;

import java.util.List;

public interface CandidateLanguagesService {

    DataResult<List<CandidateLanguages>> getAll();

    Result add(CandidateLanguages candidateLanguages);

}
