package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.JobPositions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobPositionsDao extends JpaRepository<JobPositions, Integer> {

    List<JobPositions> getJobPositionsByPosition(String position);
}
