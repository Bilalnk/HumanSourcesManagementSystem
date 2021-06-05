package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {
}
