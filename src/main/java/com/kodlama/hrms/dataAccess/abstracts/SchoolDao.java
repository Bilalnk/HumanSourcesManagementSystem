package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School, Integer> {
}
