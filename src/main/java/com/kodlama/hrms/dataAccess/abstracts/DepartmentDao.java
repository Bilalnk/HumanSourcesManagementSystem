package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

    List<Department> findByDepartmentName(String name);
}
