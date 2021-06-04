package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.LanguageLevels;

import java.util.List;

public interface LanguageLevelsService {

    DataResult<List<LanguageLevels>> getAll();

    Result add(LanguageLevels languageLevels);

}
