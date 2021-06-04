package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.LanguagesService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.LanguagesDao;
import com.kodlama.hrms.entities.concretes.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangugesManager implements LanguagesService {

    private LanguagesDao languagesDao;

    @Autowired
    public LangugesManager(LanguagesDao languagesDao) {
        this.languagesDao = languagesDao;
    }

    @Override
    public DataResult<List<Languages>> getAll() {
        return new SuccessDataResult<List<Languages>>(this.languagesDao.findAll());
    }

    @Override
    public Result add(Languages languages) {
        this.languagesDao.save(languages);
        return new SuccessResult(Messages.SUCCESS);
    }
}
