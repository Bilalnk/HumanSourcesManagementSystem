package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {

    List<Experience> findByCandidatesIdOrderByDepartureDateDesc(int candidateId);

}
