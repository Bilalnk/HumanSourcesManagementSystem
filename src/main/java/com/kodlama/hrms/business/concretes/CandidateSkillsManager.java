package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidateSkillsService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.dataAccess.abstracts.CandidateSkillsDao;
import com.kodlama.hrms.entities.concretes.CandidateSkills;
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

        if(this.skillsDao.existsByCandidatesIdAndSkillsId(candidateSkills.getCandidates().getId(), candidateSkills.getSkills().getId())){

            System.out.println("mevcut");
            return new ErrorResult("Kayıt Mevcut");
        }
        else{
            System.out.println("değil");
            this.skillsDao.save(candidateSkills);
            return new SuccessResult(Messages.SUCCESS);
        }
    }

    @Override
    public DataResult<List<CandidateSkills>> getAll() {
        return new SuccessDataResult<>(this.skillsDao.findAll());
    }

    @Override
    public DataResult<List<CandidateSkills>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.skillsDao.getByCandidatesId(candidateId));
    }

    @Override
    public Result deleteById(int id) {
        this.skillsDao.deleteById(id);
        return new SuccessResult("Silindi");
    }
}
