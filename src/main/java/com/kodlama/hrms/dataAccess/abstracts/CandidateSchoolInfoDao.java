package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.CandidateSchoolInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSchoolInfoDao extends JpaRepository<CandidateSchoolInfo, Integer> {
}
