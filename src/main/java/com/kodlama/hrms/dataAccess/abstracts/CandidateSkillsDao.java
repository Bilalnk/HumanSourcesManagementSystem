package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.CandidateSkills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateSkillsDao extends JpaRepository<CandidateSkills, Integer> {

    List<CandidateSkills> getByCandidatesId (int id);
}
