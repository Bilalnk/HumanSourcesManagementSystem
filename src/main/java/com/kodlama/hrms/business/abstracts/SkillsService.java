package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Skills;

import java.util.List;

public interface SkillsService {

    DataResult<List<Skills>> getAll();

    Result add(Skills skills);

    Result deleteById(int id);
}
