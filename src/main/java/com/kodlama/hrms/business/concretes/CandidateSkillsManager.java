package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidateSkillsService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.CandidateSkillsDao;
import com.kodlama.hrms.entities.concretes.CandidateSkills;
import com.kodlama.hrms.entities.concretes.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateSkillsManager implements CandidateSkillsService {

    private CandidateSkillsDao skillsDao;

    @Autowired
    public CandidateSkillsManager(CandidateSkillsDao skillsDao) {
        this.skillsDao = skillsDao;
    }

    @Override
    public Result addSkill(CandidateSkills candidateSkills) {
        this.skillsDao.save(candidateSkills);
        return new SuccessResult(Messages.SUCCESS);
    }

    @Override
    public DataResult<List<CandidateSkills>> getAll() {
        return new SuccessDataResult<>(this.skillsDao.findAll());
    }
}
