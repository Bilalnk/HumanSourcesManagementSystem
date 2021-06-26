package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateSkills;
import com.kodlama.hrms.entities.concretes.Skills;

import java.util.List;

public interface CandidateSkillsService {

    Result addSkill(CandidateSkills candidateSkills);

    DataResult<List<CandidateSkills>> getAll();

    DataResult<List<CandidateSkills>> getByCandidateId(int candidateId);

    Result deleteById(int id);
}
