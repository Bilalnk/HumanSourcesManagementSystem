package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsDao extends JpaRepository<Skills, Integer> {

}
