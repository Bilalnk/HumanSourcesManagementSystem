package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.CandidateLinks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateLinksDao extends JpaRepository<CandidateLinks, Integer> {
}
