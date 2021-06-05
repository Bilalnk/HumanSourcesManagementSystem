package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.ExperienceService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.ExperienceDao;
import com.kodlama.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }


    @Override
    public Result add(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult(Messages.SUCCESS);
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<>(this.experienceDao.findAll());
    }
}
