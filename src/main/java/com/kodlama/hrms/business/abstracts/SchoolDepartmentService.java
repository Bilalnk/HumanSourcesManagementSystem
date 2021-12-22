package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.SchoolDepartment;
import com.kodlama.hrms.entities.dtos.DepartmentOfSchoolDto;

import java.util.List;

public interface SchoolDepartmentService {

    Result add(SchoolDepartment schoolDepartment);

    DataResult<List<SchoolDepartment>> getAll();

    DataResult<List<SchoolDepartment>> getBySchoolId(int schoolId);

    DataResult<List<DepartmentOfSchoolDto>> findBySchoolId(int schoolId);

    DataResult<SchoolDepartment> getBySchoolIdAndDepartmentId(int schoolId, int departmentId);
}
