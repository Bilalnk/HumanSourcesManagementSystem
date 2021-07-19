package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Employees;

import java.util.List;

public interface EmployeesService {

    DataResult<List<Employees>> getAll();

    DataResult<Employees> add(Employees employees);

    Result confirmEmployer(int id, boolean active);

    boolean isExist (int employeesId);
}
