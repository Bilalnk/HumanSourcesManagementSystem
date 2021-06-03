package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.SchoolService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.SchoolDao;
import com.kodlama.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {


    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("Eklendi");
    }
}

