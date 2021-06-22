package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.CandidateLanguages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateLanguagesDao extends JpaRepository<CandidateLanguages, Integer> {

    List<CandidateLanguages> getByCandidatesId (int candidateId);

}
