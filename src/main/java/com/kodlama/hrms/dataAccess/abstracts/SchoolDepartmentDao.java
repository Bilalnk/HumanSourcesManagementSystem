package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.SchoolDepartment;
import com.kodlama.hrms.entities.dtos.DepartmentOfSchoolDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer> {

    List<SchoolDepartment> getBySchoolId(int id);

    SchoolDepartment getBySchoolIdAndDepartmentId(int schoolId, int departmentId);

    @Query("select new com.kodlama.hrms.entities.dtos.DepartmentOfSchoolDto(sd.department.id, sd.department.departmentName)" +
    "from SchoolDepartment sd where  sd.school.id= :id")
    List<DepartmentOfSchoolDto> getBySchool(int id);




}
