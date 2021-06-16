package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer> {
}
