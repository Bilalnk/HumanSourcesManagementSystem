package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {

    DataResult<List<Department>> getAll();

    Result add(Department department);

    DataResult<List<Department>> findByName(String name);
}
