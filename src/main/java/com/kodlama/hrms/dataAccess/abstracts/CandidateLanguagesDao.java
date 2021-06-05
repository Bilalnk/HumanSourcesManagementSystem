package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.CandidateLanguages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateLanguagesDao extends JpaRepository<CandidateLanguages, Integer> {
}
