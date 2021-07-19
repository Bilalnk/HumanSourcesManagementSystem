package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateLinks;
import com.kodlama.hrms.entities.concretes.Candidates;
import com.kodlama.hrms.entities.dtos.CandidateLinksDto;

import java.util.List;

public interface CandidateLinksService {

    Result add(CandidateLinks candidateLinks);

    DataResult<List<CandidateLinks>> getAll();

    DataResult<List<CandidateLinks>> getByCandidateId(int id);

    DataResult<List<CandidateLinksDto>> getAllDtoByCandidateId(int id);

}
