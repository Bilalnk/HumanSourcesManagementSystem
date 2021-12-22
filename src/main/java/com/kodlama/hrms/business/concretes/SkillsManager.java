package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.SkillsService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.SkillsDao;
import com.kodlama.hrms.entities.concretes.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsManager implements SkillsService {

    private SkillsDao skillsDao;

    @Autowired
    public SkillsManager(SkillsDao skillsDao) {
        this.skillsDao = skillsDao;
    }

    @Override
    public DataResult<List<Skills>> getAll() {
        return new SuccessDataResult<>(this.skillsDao.findAll());
    }

    @Override
    public Result add(Skills skills) {
        this.skillsDao.save(skills);
        return new SuccessResult(Messages.SUCCESS);
    }

    @Override
    public Result deleteById(int id) {
         this.skillsDao.deleteById(id);
         return new SuccessResult("Silindi");
    }
}
