package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.LanguageLevelsService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.LanguageLevelsDao;
import com.kodlama.hrms.entities.concretes.LanguageLevels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageLevelsManager implements LanguageLevelsService {

    private LanguageLevelsDao languageLevelsDao;

    @Autowired
    public LanguageLevelsManager(LanguageLevelsDao languageLevelsDao) {
        this.languageLevelsDao = languageLevelsDao;
    }

    @Override
    public DataResult<List<LanguageLevels>> getAll() {
        return new SuccessDataResult<List<LanguageLevels>>(this.languageLevelsDao.findAll());
    }

    @Override
    public Result add(LanguageLevels languageLevels) {
        this.languageLevelsDao.save(languageLevels);
        return new SuccessResult(Messages.SUCCESS);
    }
}
