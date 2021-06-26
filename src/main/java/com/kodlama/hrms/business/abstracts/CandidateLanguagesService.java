package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateLanguages;

import java.util.List;

public interface CandidateLanguagesService {

    DataResult<List<CandidateLanguages>> getAll();

    DataResult<List<CandidateLanguages>> getByCandidateId(int candidateId);

    Result add(CandidateLanguages candidateLanguages);

    Result update(int id, int languageId, int languageLevelsId);

}
