package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.SchoolDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer> {
}
