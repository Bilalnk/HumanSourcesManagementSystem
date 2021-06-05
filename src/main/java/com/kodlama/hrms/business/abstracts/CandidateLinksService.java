package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateLinks;
import com.kodlama.hrms.entities.concretes.Candidates;

import java.util.List;

public interface CandidateLinksService {

    Result add(CandidateLinks candidateLinks);

    DataResult<List<CandidateLinks>> getAll();

}