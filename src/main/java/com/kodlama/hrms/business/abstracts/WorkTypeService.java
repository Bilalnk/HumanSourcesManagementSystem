package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.WorkType;

import java.util.List;

public interface WorkTypeService {

    DataResult<List<WorkType>> getAll();
}
