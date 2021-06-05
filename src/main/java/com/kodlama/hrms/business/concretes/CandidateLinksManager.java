package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidateLinksService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.CandidateLinksDao;
import com.kodlama.hrms.entities.concretes.CandidateLinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateLinksManager implements CandidateLinksService {

    private CandidateLinksDao candidateLinksDao;

    @Autowired
    public CandidateLinksManager(CandidateLinksDao candidateLinksDao) {
        this.candidateLinksDao = candidateLinksDao;
    }

    @Override
    public Result add(CandidateLinks candidateLinks) {
        this.candidateLinksDao.save(candidateLinks);
        return new SuccessResult(Messages.SUCCESS);
    }

    @Override
    public DataResult<List<CandidateLinks>> getAll() {
        return new SuccessDataResult<>(this.candidateLinksDao.findAll());
    }
}
