package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.CandidateSkills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSkillsDao extends JpaRepository<CandidateSkills, Integer> {
}
