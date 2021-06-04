package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Languages;

import java.util.List;

public interface LanguagesService {

    DataResult<List<Languages>> getAll();

    Result add(Languages languages);
}
