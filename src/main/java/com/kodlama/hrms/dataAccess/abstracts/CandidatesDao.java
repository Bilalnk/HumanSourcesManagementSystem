package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesDao extends JpaRepository<Candidates, Integer> {

    boolean existsCandidatesByEmail(String email);

    boolean existsCandidatesByIdentityNumber(String identityNumber);

}
