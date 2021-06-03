package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {

    DataResult<List<School>> getAll();

    Result add(School school);

}
