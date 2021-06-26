package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.CandidateSchoolInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateSchoolInfoDao extends JpaRepository<CandidateSchoolInfo, Integer> {

    List<CandidateSchoolInfo> getByCandidatesIdOrderByDateOfFinishDesc(int candidateId);

    boolean existsByCandidatesIdAndSchoolDepartmentId(int candidateId, int schoolDepId);

}
