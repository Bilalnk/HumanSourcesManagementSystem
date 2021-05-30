package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.Employers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployersDao extends JpaRepository<Employers, Integer> {

    boolean existsById(int id);

    boolean existsByEmail(String email);

}
