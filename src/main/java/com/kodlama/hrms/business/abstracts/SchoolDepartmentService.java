package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.SchoolDepartment;

import java.util.List;

public interface SchoolDepartmentService {

    Result add(SchoolDepartment schoolDepartment);

    DataResult<List<SchoolDepartment>> getAll();

}
