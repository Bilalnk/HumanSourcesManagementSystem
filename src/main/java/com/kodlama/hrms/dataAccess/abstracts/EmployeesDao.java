package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesDao extends JpaRepository<Employees, Integer> {
}
