package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidateSchoolInfoService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.dataAccess.abstracts.CandidateSchoolInfoDao;
import com.kodlama.hrms.entities.concretes.CandidateSchoolInfo;
import com.kodlama.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateSchoolInfoManager implements CandidateSchoolInfoService {

    private CandidateSchoolInfoDao candidateSchoolInfoDao;

    @Autowired
    public CandidateSchoolInfoManager(CandidateSchoolInfoDao candidateSchoolInfoDao) {
        this.candidateSchoolInfoDao = candidateSchoolInfoDao;
    }

    @Override
    public Result add(CandidateSchoolInfo candidateSchoolInfo) {
        if(this.candidateSchoolInfoDao.existsById(candidateSchoolInfo.getSchoolDepartment().getId())){
            return new ErrorResult("Bu üniversite ve bölüm ile kayıt mevcut");
        }
        this.candidateSchoolInfoDao.save(candidateSchoolInfo);
        return new SuccessResult(Messages.SUCCESS);
    }

    @Override
    public DataResult<List<CandidateSchoolInfo>> getAll() {
        return new SuccessDataResult<List<CandidateSchoolInfo>>(this.candidateSchoolInfoDao.findAll(), Messages.SUCCESS);
    }

    @Override
    public DataResult<List<CandidateSchoolInfo>> getByCandidatesIdOrderByDateOfFinishDesc(int candidateId) {
        return new SuccessDataResult<List<CandidateSchoolInfo>>(this.candidateSchoolInfoDao.getByCandidatesIdOrderByDateOfFinishDesc(candidateId));
    }

}
