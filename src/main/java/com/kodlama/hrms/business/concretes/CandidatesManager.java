package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidatesService;
import com.kodlama.hrms.dataAccess.abstracts.CandidatesDao;
import com.kodlama.hrms.entities.concretes.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesManager implements CandidatesService {

    private CandidatesDao candidatesDao;

    @Autowired
    public CandidatesManager(CandidatesDao candidatesDao) {
        this.candidatesDao = candidatesDao;
    }

    @Override
    public List<Candidates> getAll() {
        return this.candidatesDao.findAll();
    }
}
